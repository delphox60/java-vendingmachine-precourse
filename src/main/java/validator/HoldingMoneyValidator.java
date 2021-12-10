package validator;

public class HoldingMoneyValidator {

    private static final String NOT_A_NUMBER_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액은 숫자만 입력할 수 있습니다.";
    private static final String NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액은 0 이상이어야 합니다.";
    private static final String NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE = "[ERROR] 자판기 보유 금액의 최소 단위는 10이어야 합니다.";

    private HoldingMoneyValidator() {
    }

    public static int getValidHoldingMoney(final String inputValue) {
        int intInputValue = GeneralValidator.getValidInteger(inputValue, NOT_A_NUMBER_ERROR_MESSAGE);
        GeneralValidator.validateNonNegativeNumber(intInputValue, NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE);
        GeneralValidator.validateDivisibleByTen(intInputValue, NOT_DIVISIBLE_BY_TEN_ERROR_MESSAGE);
        return intInputValue;
    }
}
