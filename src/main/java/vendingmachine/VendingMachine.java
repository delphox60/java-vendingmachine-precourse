package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import validator.HoldingMoneyValidator;

public class VendingMachine {
    private int holdingMoney;

    public VendingMachine() {
        inputHoldingMoney();
    }

    public void inputHoldingMoney() {
        String inputValue = Console.readLine();
        try {
            holdingMoney = HoldingMoneyValidator.validateHoldingMoney(inputValue);
        } catch (IllegalArgumentException e) {
            inputHoldingMoney();
        }
    }
}
