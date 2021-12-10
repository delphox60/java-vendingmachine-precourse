package validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuValidator {
    private final static Pattern MENU_FORMAT_PATTERN = Pattern.compile("^\\[(.*),(.*),(.*)\\]$");
    private final static int MENU_NAME_GROUP_INDEX = 1;
    private final static int MENU_PRICE_GROUP_INDEX = 2;
    private final static int MENU_STOCK_GROUP_INDEX = 3;

    private MenuValidator() {
    }

    public static List<String> validateMenu(final String menuInput) {
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

    // TODO private static void validateMenuName(String menuName)
    // TODO private static void validateMenuPrice(String menuPrice)
    // TODO private static void validateMenuStock(String menuStock)
}
