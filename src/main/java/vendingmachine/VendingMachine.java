package vendingmachine;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import constant.CoinInfo;
import constant.ConsoleMessage;
import validator.HoldingMoneyValidator;
import validator.ProductValidator;

public class VendingMachine {
    private CoinCase coinCase;
    private Storage storage;

    public VendingMachine() {
        coinCase = new CoinCase(getInputHoldingMoney());
        storage = new Storage();
    }

    public void execute() {
        printOutHoldingCoins();
        initializeProducts();
    }

    private void initializeProducts() {
        List<Product> productList = getProductList();
        productList.forEach(product -> storage.putProduct(product));
    }

    private List<Product> getProductList() {
        System.out.println(ConsoleMessage.PRODUCT_INFOS_INPUT_REQUEST_MESSAGE);
        String inputProductsInfo = Console.readLine();
        List<Product> productList;
        try {
            productList = ProductValidator.getValidProductList(inputProductsInfo);
        } catch (IllegalArgumentException e) {
            productList = getProductList();
        }
        return productList;
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
