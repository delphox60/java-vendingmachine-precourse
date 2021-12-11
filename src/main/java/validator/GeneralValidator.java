package validator;

public class GeneralValidator {

    private static final int AMOUNT_OF_MIN_UNIT_COIN = 10;
    private static final int BILLION = 1000000000;

    private GeneralValidator() {
    }

    public static int getValidInteger(final String inputValue, final String errorMessage) {
        int intInputValue;
        try {
            intInputValue = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
        return intInputValue;
    }

    public static void validateNonNegativeNumber(final int inputValue, final String errorMessage) {
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

    public static void validateBeingDropped(final String inputValue, final String errorMessage) {
        if (inputValue.length() == 0) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static void validateLessThanBillion(final int inputValue, final String errorMessage) {
        if (inputValue > BILLION) {
            System.out.println(errorMessage);
            throw new IllegalArgumentException();
        }
    }
}
