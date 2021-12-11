package vendingmachine;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constant.CoinInfo;
import constant.ConsoleMessage;
import validator.HoldingMoneyValidator;
import validator.InputAmountValidator;
import validator.ProductValidator;

public class VendingMachine {
    private CoinCase coinCase;
    private Storage storage;
    private int inputAmount;

    public VendingMachine() {
        coinCase = new CoinCase(inputHoldingMoney());
        storage = new Storage();
    }

    public void execute() {
        printOutHoldingCoins();
        initializeProducts();
        setInputAmount(inputInputAmount());
        while (storage.checkPurchaseAble(inputAmount)) {
            // TODO purchase product

        }
    }

    private void initializeProducts() {
        List<Product> productList = inputProductList();
        productList.forEach(product -> storage.putProduct(product));
    }

    private void setInputAmount(final int inputAmount) {
        this.inputAmount = inputAmount;
    }

    private int inputInputAmount() {
        System.out.println(ConsoleMessage.INPUT_AMOUNT_INPUT_REQUEST_MESSAGE);
        String inputInputAmount = Console.readLine();
        int intInputInputAmount;
        try {
            intInputInputAmount = InputAmountValidator.getValidInputAmount(inputInputAmount);
        } catch (IllegalArgumentException e) {
            intInputInputAmount = inputInputAmount();
        }
        return intInputInputAmount;
    }

    private List<Product> inputProductList() {
        System.out.println(ConsoleMessage.PRODUCT_INFOS_INPUT_REQUEST_MESSAGE);
        String inputProductsInfo = Console.readLine();
        List<Product> productList;
        try {
            productList = ProductValidator.getValidProductList(inputProductsInfo);
        } catch (IllegalArgumentException e) {
            productList = inputProductList();
        }
        return productList;
    }

    private int inputHoldingMoney() {
        System.out.println(ConsoleMessage.HOLDING_MONEY_INPUT_REQUEST_MESSAGE);
        String inputValue = Console.readLine();
        int holdingMoney;
        try {
            holdingMoney = HoldingMoneyValidator.getValidHoldingMoney(inputValue);
        } catch (IllegalArgumentException e) {
            holdingMoney = inputHoldingMoney();
        }
        return holdingMoney;
    }

    private void printOutHoldingCoins() {
        System.out.println(ConsoleMessage.HOLDING_MONEY_INFO_MESSAGE);
        printOutHoldingCoinUnit(CoinInfo.COIN_500_NAME);
        printOutHoldingCoinUnit(CoinInfo.COIN_100_NAME);
        printOutHoldingCoinUnit(CoinInfo.COIN_50_NAME);
        printOutHoldingCoinUnit(CoinInfo.COIN_10_NAME);
    }

    private void printOutHoldingCoinUnit(String coinUnit) {
        System.out.print(Coin.valueOf(coinUnit).getAmount());
        System.out.print(ConsoleMessage.WON_UNIT + ConsoleMessage.HYPHEN);
        System.out.print(coinCase.getHolingCoinUnits(coinUnit));
        System.out.println(ConsoleMessage.UNIT_NUMBER);
    }

    private void printOutInputAmount() {
        System.out.print(ConsoleMessage.INPUT_AMOUNT_INFO_MESSAGE);
        System.out.print(inputAmount);
        System.out.println(ConsoleMessage.WON_UNIT);
    }
}
