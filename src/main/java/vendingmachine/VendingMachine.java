package vendingmachine;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constant.CoinInfo;
import constant.ConsoleMessage;
import validator.HoldingMoneyValidator;
import validator.MenuValidator;

public class VendingMachine {
    private CoinCase coinCase;

    public VendingMachine() {
        coinCase = new CoinCase(getInputHoldingMoney());
    }

    public void execute() {
        printOutHoldingCoins();
        List<String> MenuList = getInputMenu();
    }

    private List<String> getInputMenu() {
        System.out.println(ConsoleMessage.MENU_INPUT_REQUEST_MESSAGE);
        String menuInput = Console.readLine();
        List<String> menuInputList;
        try {
            menuInputList = MenuValidator.getValidMenu(menuInput);
        } catch (IllegalArgumentException e) {
            menuInputList = getInputMenu();
        }
        return menuInputList;
    }

    private int getInputHoldingMoney() {
        System.out.println(ConsoleMessage.HOLDING_MONEY_INPUT_REQUEST_MESSAGE);
        String inputValue = Console.readLine();
        int holdingMoney;
        try {
            holdingMoney = HoldingMoneyValidator.getValidHoldingMoney(inputValue);
        } catch (IllegalArgumentException e) {
            holdingMoney = getInputHoldingMoney();
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
