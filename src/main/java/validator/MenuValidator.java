package validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuValidator {

    private static final String DROPPED_INFO_ERROR_MESSAGE = "[ERROR] 누락된 정보가 있습니다. 상품명, 가격, 수량을 확인해 주세요.";
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

    private static void validateMenuFormat(String menu) {
        Matcher menuFormatMatcher = MENU_FORMAT_PATTERN.matcher(menu);
        if (!menuFormatMatcher.matches()) {
            throw new IllegalArgumentException();
        }
        validateMenuName(menuFormatMatcher.group(MENU_NAME_GROUP_INDEX));
        validateMenuPrice(menuFormatMatcher.group(MENU_PRICE_GROUP_INDEX));
        validateMenuStock(menuFormatMatcher.group(MENU_STOCK_GROUP_INDEX));
    }

    private static void validateMenuName(final String menuName) {
        GeneralValidator.validateBeingDropped(menuName, DROPPED_INFO_ERROR_MESSAGE);
        validateMenuNameValidity(menuName);
    }

    private static void validateMenuNameValidity(String menuName) {
        Matcher menuNameMatcher = MENU_NAME_PATTERN.matcher(menuName);
        if (!menuNameMatcher.matches()) {
            System.out.println(INVALID_MENU_NAME_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    // TODO private static void validateMenuPrice(String menuPrice)
    // TODO private static void validateMenuStock(String menuStock)
}
