package validator;

public class HoldingMoneyValidator {

    private static final String NOT_A_NUMBER_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액은 숫자만 입력할 수 있습니다.";
    private static final String NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액은 0 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액의 최소 단위는 10이어야 합니다.";
    private static final int UNIT_OF_HOLDING_MONEY = 10;

    private HoldingMoneyValidator() {
    }

    public static int validateHoldingMoney(final String inputValue) {
        int intInputValue;
        try {
            intInputValue = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR_MESSAGE);
        }
        validatePositiveNumber(intInputValue);
        validateDivisibleByTen(intInputValue);
        return intInputValue;
    }

    private static void validatePositiveNumber(final int inputValue) {
        if (inputValue < 0) {
            throw new IllegalArgumentException(NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateDivisibleByTen(final int inputValue) {
        if (inputValue % UNIT_OF_HOLDING_MONEY != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE);
        }
    }
}
