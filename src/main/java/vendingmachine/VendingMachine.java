package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import constant.CoinInfo;
import constant.ConsoleMessage;
import validator.HoldingMoneyValidator;

public class VendingMachine {
    private CoinCase coinCase;

    public VendingMachine() {
        coinCase = new CoinCase(inputHoldingMoney());
    }

    public void execute() {
        printOutHoldingCoins();
    }

    private int inputHoldingMoney() {
        System.out.println(ConsoleMessage.HOLDING_MONEY_INPUT_REQUEST_MESSAGE);
        String inputValue = Console.readLine();
        int holdingMoney;
        try {
            holdingMoney = HoldingMoneyValidator.validateHoldingMoney(inputValue);
        } catch (IllegalArgumentException e) {
            holdingMoney = inputHoldingMoney();
        }
        return holdingMoney;
    }

    private void printOutHoldingCoins() {
        System.out.println(ConsoleMessage.HOLDING_MONEY_INFO_MESSAGE);
        printOutHoldingCoinUnits(CoinInfo.COIN_500_NAME);
        printOutHoldingCoinUnits(CoinInfo.COIN_100_NAME);
        printOutHoldingCoinUnits(CoinInfo.COIN_50_NAME);
        printOutHoldingCoinUnits(CoinInfo.COIN_10_NAME);
    }

    private void printOutHoldingCoinUnits(String coinUnit) {
        System.out.print(Coin.valueOf(coinUnit).getAmount());
        System.out.print(ConsoleMessage.NUMBER_OF_COIN_UNIT);
        System.out.print(coinCase.getHolingCoinUnits(coinUnit));
        System.out.println(ConsoleMessage.UNIT_NUMBER);
    }
}
