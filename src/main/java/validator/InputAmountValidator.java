package validator;

public class InputAmountValidator {

    private static final String NOT_A_NUMBER_ERROR_MESSAGE = "[ERROR] 투입 금액은 숫자만 입력할 수 있습니다.";
    private static final String NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 투입 금액은 0 이상이어야 합니다.";

    private InputAmountValidator() {
    }

    public static int getValidInputAmount(final String inputValue) {
        int intInputValue = GeneralValidator.getValidInteger(inputValue, NOT_A_NUMBER_ERROR_MESSAGE);
        GeneralValidator.validateNonNegativeNumber(intInputValue, NOT_A_POSITIVE_NUMBER_ERROR_MESSAGE);
        return intInputValue;
    }
}
