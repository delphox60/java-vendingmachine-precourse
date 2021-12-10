package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

    private static Product getValidProduct(final String productInfo) {
        Matcher productFormatMatcher = PRODUCT_FORMAT_PATTERN.matcher(productInfo);
        if (!productFormatMatcher.matches()) {
            System.out.println(ErrorMessage.PRODUCT_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        String validProductName = getValidProductName(productFormatMatcher.group(PRODUCT_NAME_GROUP_INDEX));
        int validProductPrice = getValidProductPrice(productFormatMatcher.group(PRODUCT_PRICE_GROUP_INDEX));
        int validProductStock = getValidProductStock(productFormatMatcher.group(PRODUCT_STOCK_GROUP_INDEX));
        return new Product(validProductName, validProductPrice, validProductStock);
    }

    private static String getValidProductName(final String productName) {
        GeneralValidator.validateBeingDropped(productName, ErrorMessage.DROPPED_INFO_ERROR_MESSAGE);
        validateProductNameLetters(productName);
        return productName;
    }

    private static void validateProductNameLetters(final String productName) {
        Matcher productNameMatcher = PRODUCT_NAME_PATTERN.matcher(productName);
        if (!productNameMatcher.matches()) {
            System.out.println(ErrorMessage.INVALID_PRODUCT_NAME_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static int getValidProductPrice(final String productPrice) {
        GeneralValidator.validateBeingDropped(productPrice, ErrorMessage.DROPPED_INFO_ERROR_MESSAGE);
        int intProductPrice = GeneralValidator.getValidInteger(productPrice, ErrorMessage.NOT_A_NUMBER_PRICE_ERROR_MESSAGE);
        validateGreaterThanMinPrice(intProductPrice);
        GeneralValidator.validateDivisibleByTen(intProductPrice, ErrorMessage.NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE);
        return intProductPrice;
    }

    private static int getValidProductStock(final String productStock) {
        GeneralValidator.validateBeingDropped(productStock, ErrorMessage.DROPPED_INFO_ERROR_MESSAGE);
        int intProductStock = GeneralValidator.getValidInteger(productStock, ErrorMessage.NOT_A_NUMBER_STOCK_ERROR_MESSAGE);
        GeneralValidator.validateNonNegativeNumber(intProductStock, ErrorMessage.LESS_THAN_0_STOCK_ERROR_MESSAGE);
        return intProductStock;
    }

    private static void validateGreaterThanMinPrice(final int price) {
        if (price < 100) {
            System.out.println(ErrorMessage.LESS_THAN_100_PRICE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
