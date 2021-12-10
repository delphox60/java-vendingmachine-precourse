package validator;

public class GeneralValidator {

    private static final int AMOUNT_OF_MIN_UNIT_COIN = 10;

    private GeneralValidator() {}

    public static int validateInteger(final String inputValue, final String errorMessage) {
        int intInputValue;
        try {
            intInputValue = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
        return intInputValue;
    }

    public static void validatePositiveNumber(final int inputValue, final String errorMessage) {
        if (inputValue < 0) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static void validateDivisibleByTen(final int inputValue, final String errorMessage) {
        if (inputValue % AMOUNT_OF_MIN_UNIT_COIN != 0) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }
}
