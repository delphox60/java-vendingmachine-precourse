package validator;

import constant.ErrorMessage;

public class InputAmountValidator {

    private InputAmountValidator() {
    }

    public static int getValidInputAmount(final String inputValue) {
        int intInputValue = GeneralValidator.getValidInteger(inputValue, ErrorMessage.INPUT_AMOUNT_NOT_A_VALID_NUMBER);
        GeneralValidator.validateLessThanBillion(intInputValue, ErrorMessage.INPUT_AMOUNT_NOT_A_VALID_NUMBER);
        GeneralValidator.validateNonNegativeNumber(intInputValue, ErrorMessage.INPUT_AMOUNT_NOT_A_POSITIVE_NUMBER);
        return intInputValue;
    }
}
