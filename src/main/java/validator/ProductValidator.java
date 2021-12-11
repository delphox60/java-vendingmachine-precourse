package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import constant.ErrorMessage;
import vendingmachine.Product;

public class ProductValidator {

    private static final String SEMICOLON_SEPARATION_REGEX = "\\s*;\\s*";
    private static final Pattern PRODUCT_FORMAT_PATTERN = Pattern.compile("^\\[(.*),(.*),(.*)\\]$");
    private static final Pattern PRODUCT_NAME_PATTERN = Pattern.compile("^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9]+$");
    private static final int PRODUCT_NAME_GROUP_INDEX = 1;
    private static final int PRODUCT_PRICE_GROUP_INDEX = 2;
    private static final int PRODUCT_STOCK_GROUP_INDEX = 3;

    private ProductValidator() {
    }

    public static List<Product> getValidProductList(final String productInfosInput) {
        List<Product> products = new ArrayList<>();
        Stream<String> productInfoStream = Arrays.stream(productInfosInput.split(SEMICOLON_SEPARATION_REGEX));
        productInfoStream.forEach(productInfo -> products.add(getValidProduct(productInfo)));
        return products;
    }

    public static void validateProductName(final String productName) {
        GeneralValidator.validateBeingDropped(productName, ErrorMessage.IPRODUCT_NAME_TO_PURCHASE_INVALID);
        validateProductNameLetters(productName);
    }

    private static Product getValidProduct(final String productInfo) {
        Matcher productFormatMatcher = PRODUCT_FORMAT_PATTERN.matcher(productInfo);
        if (!productFormatMatcher.matches()) {
            System.out.println(ErrorMessage.PRODUCT_INVALID_FORMAT);
            throw new IllegalArgumentException();
        }
        String validProductName = getValidProductName(productFormatMatcher.group(PRODUCT_NAME_GROUP_INDEX));
        int validProductPrice = getValidProductPrice(productFormatMatcher.group(PRODUCT_PRICE_GROUP_INDEX));
        int validProductStock = getValidProductStock(productFormatMatcher.group(PRODUCT_STOCK_GROUP_INDEX));
        return new Product(validProductName, validProductPrice, validProductStock);
    }

    private static String getValidProductName(final String productName) {
        GeneralValidator.validateBeingDropped(productName, ErrorMessage.PRODUCT_DROPPED_INFO);
        validateProductNameLetters(productName);
        return productName;
    }

    private static void validateProductNameLetters(final String productName) {
        Matcher productNameMatcher = PRODUCT_NAME_PATTERN.matcher(productName);
        if (!productNameMatcher.matches()) {
            System.out.println(ErrorMessage.PRODUCT_INVALID_NAME);
            throw new IllegalArgumentException();
        }
    }

    private static int getValidProductPrice(final String productPrice) {
        GeneralValidator.validateBeingDropped(productPrice, ErrorMessage.PRODUCT_DROPPED_INFO);
        int intProductPrice = GeneralValidator.getValidInteger(productPrice, ErrorMessage.PRODUCT_NOT_A_VALID_NUMBER_PRICE);
        GeneralValidator.validateLessThanBillion(intProductPrice, ErrorMessage.PRODUCT_NOT_A_VALID_NUMBER_PRICE);
        validateGreaterThanMinPrice(intProductPrice);
        GeneralValidator.validateDivisibleByTen(intProductPrice, ErrorMessage.PRODUCT_NOT_DIVISIBLE_BY_10_PRICE);
        return intProductPrice;
    }

    private static int getValidProductStock(final String productStock) {
        GeneralValidator.validateBeingDropped(productStock, ErrorMessage.PRODUCT_DROPPED_INFO);
        int intProductStock = GeneralValidator.getValidInteger(productStock, ErrorMessage.PRODUCT_NOT_A_VALID_NUMBER_STOCK);
        GeneralValidator.validateLessThanBillion(intProductStock, ErrorMessage.PRODUCT_NOT_A_VALID_NUMBER_STOCK);
        GeneralValidator.validateNonNegativeNumber(intProductStock, ErrorMessage.PRODUCT_LESS_THAN_0_STOCK);
        return intProductStock;
    }

    private static void validateGreaterThanMinPrice(final int price) {
        if (price < 100) {
            System.out.println(ErrorMessage.PRODUCT_LESS_THAN_100_PRICE);
            throw new IllegalArgumentException();
        }
    }
}
