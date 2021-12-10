package validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuValidator {

    private static final String MENU_FORMAT_ERROR_MESSAGE = "[ERROR] 상품 정보 형식이 올바르지 않습니다. \"[상품명1, 상품 가격1, 상품 수량1];[상품명2, 상품 가격2, 상품 수량2]...\" 형식으로 입력해 주세요.";
    private static final String DROPPED_INFO_ERROR_MESSAGE = "[ERROR] 누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
    private static final String NOT_A_NUMBER_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 반드시 숫자여야 합니다.";
    private static final String NOT_A_NUMBER_STOCK_ERROR_MESSAGE = "[ERROR] 상품 수량은 반드시 숫자여야 합니다.";
    private static final String LESS_THAN_100_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 반드시 100원 이상이어야 합니다.";
    private static final String LESS_THAN_0_STOCK_ERROR_MESSAGE = "[ERROR] 상품 수량은 반드시 0 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격의 최소 단위는 10이어야 합니다.";
    private static final String INVALID_MENU_NAME_ERROR_MESSAGE = "[ERROR] 상품명은 한글, 숫자, 영문으로만 이루어진 이름이어야 합니다.";
    private static final Pattern MENU_FORMAT_PATTERN = Pattern.compile("^\\[(.*),(.*),(.*)\\]$");
    private static final Pattern MENU_NAME_PATTERN = Pattern.compile("^[가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9]+$");
    private static final int MENU_NAME_GROUP_INDEX = 1;
    private static final int MENU_PRICE_GROUP_INDEX = 2;
    private static final int MENU_STOCK_GROUP_INDEX = 3;

    private MenuValidator() {
    }

    public static List<String> getValidMenu(final String menuInput) {
        Stream<String> menuStream = Arrays.stream(menuInput.split(";"));
        menuStream.forEach(MenuValidator::validateMenuFormat);
        return menuStream.collect(Collectors.toList());
    }

    private static void validateMenuFormat(final String menu) {
        Matcher menuFormatMatcher = MENU_FORMAT_PATTERN.matcher(menu);
        if (!menuFormatMatcher.matches()) {
            System.out.println(MENU_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        validateMenuName(menuFormatMatcher.group(MENU_NAME_GROUP_INDEX));
        validateMenuPrice(menuFormatMatcher.group(MENU_PRICE_GROUP_INDEX));
        validateMenuStock(menuFormatMatcher.group(MENU_STOCK_GROUP_INDEX));
    }

    private static void validateMenuName(final String menuName) {
        GeneralValidator.validateBeingDropped(menuName, DROPPED_INFO_ERROR_MESSAGE);
        validateMenuNameLetters(menuName);
    }

    private static void validateMenuNameLetters(final String menuName) {
        Matcher menuNameMatcher = MENU_NAME_PATTERN.matcher(menuName);
        if (!menuNameMatcher.matches()) {
            System.out.println(INVALID_MENU_NAME_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void validateMenuPrice(final String menuPrice) {
        GeneralValidator.validateBeingDropped(menuPrice, DROPPED_INFO_ERROR_MESSAGE);
        int intMenuPrice = GeneralValidator.getValidInteger(menuPrice, NOT_A_NUMBER_PRICE_ERROR_MESSAGE);
        validateSatisfyMinPrice(intMenuPrice);
        GeneralValidator.validateDivisibleByTen(intMenuPrice, NOT_DIVISIBLE_BY_10_PRICE_ERROR_MESSAGE);
    }

    private static void validateMenuStock(final String menuStock) {
        GeneralValidator.validateBeingDropped(menuStock, DROPPED_INFO_ERROR_MESSAGE);
        int intMenuStock = GeneralValidator.getValidInteger(menuStock, NOT_A_NUMBER_STOCK_ERROR_MESSAGE);
        GeneralValidator.validateNonNegativeNumber(intMenuStock, LESS_THAN_0_STOCK_ERROR_MESSAGE);
    }

    private static void validateSatisfyMinPrice(final int price) {
        if (price < 100) {
            System.out.println(LESS_THAN_100_PRICE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
