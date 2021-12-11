package validator;

import constant.ErrorMessage;

public class HoldingMoneyValidator {

    private HoldingMoneyValidator() {
    }

    public static int getValidHoldingMoney(final String inputValue) {
        int intInputValue = GeneralValidator.getValidInteger(inputValue, ErrorMessage.HOLDING_MONEY_NOT_A_VALID_NUMBER);
        GeneralValidator.validateLessThanBillion(intInputValue, ErrorMessage.HOLDING_MONEY_NOT_A_VALID_NUMBER);
        GeneralValidator.validateNonNegativeNumber(intInputValue, ErrorMessage.HOLDING_MONEY_NOT_A_POSITIVE_NUMBER);
        GeneralValidator.validateDivisibleByTen(intInputValue, ErrorMessage.HOLDING_MONEY_NOT_DIVISIBLE_BY_TEN);
        return intInputValue;
    }
}
