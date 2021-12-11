package vendingmachine;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import constant.CoinInfo;
import constant.ConsoleMessage;

public class CoinCase {
    private HashMap<String, Integer> quantityOfCoins;

    public CoinCase(int initHoldingMoney) {
        initializeQuantityOfCoins();
        while (getHoldingMoney() != initHoldingMoney) {
            int needAmount = initHoldingMoney - getHoldingMoney();
            randomlyGenerateCoin(needAmount);
        }
    }

    public int getHolingCoinUnits(String coinUnit) {
        return quantityOfCoins.get(coinUnit);
    }

    public void returnChange(final int inputAmount) {
        int remainChangeToReturn = inputAmount;
        System.out.println(ConsoleMessage.CHANGE_INFO_MESSAGE);
        for (int i = 0; i < 4; i++) {
            remainChangeToReturn = returnChangeInCoin(getCoinAtOrdinalIndex(i), remainChangeToReturn);
        }
    }

    private int returnChangeInCoin(final Coin coin, int remainChangeToReturn) {
        int returnAmountOfCoin = 0;
        while (getCoinUnitsTotalAmount(coin.name()) > 0 && remainChangeToReturn > 0) {
            remainChangeToReturn -= coin.getAmount();
            pullOut(coin);
            returnAmountOfCoin++;
        }
        printOutChange(coin, returnAmountOfCoin);
        return remainChangeToReturn;
    }

    private void printOutChange(final Coin coin, final int returnAmountOfCoin) {
        System.out.print(coin.getAmount());
        System.out.print(ConsoleMessage.WON_UNIT);
        System.out.print(ConsoleMessage.HYPHEN);
        System.out.print(returnAmountOfCoin);
        System.out.println(ConsoleMessage.UNIT_NUMBER);
    }

    private void randomlyGenerateCoin(final int needAmount) {
        Coin pickedCoin;
        do {
            pickedCoin = getCoinAtOrdinalIndex(Randoms.pickNumberInRange(0, 3));
        } while (pickedCoin.getAmount() > needAmount);
        pushIn(pickedCoin);
    }

    private Coin getCoinAtOrdinalIndex(final int ordinalIndex) {
        if (ordinalIndex == 0) {
            return Coin.COIN_500;
        }
        if (ordinalIndex == 1) {
            return Coin.COIN_100;
        }
        if (ordinalIndex == 2) {
            return Coin.COIN_50;
        }
        return Coin.COIN_10;
    }

    private void initializeQuantityOfCoins() {
        quantityOfCoins = new HashMap<>(4);
        quantityOfCoins.put(CoinInfo.COIN_500_NAME, 0);
        quantityOfCoins.put(CoinInfo.COIN_100_NAME, 0);
        quantityOfCoins.put(CoinInfo.COIN_50_NAME, 0);
        quantityOfCoins.put(CoinInfo.COIN_10_NAME, 0);
    }

    private int getHoldingMoney() {
        int totalHoldingMoney = 0;
        for (String coinUnitName : quantityOfCoins.keySet()) {
            totalHoldingMoney += getCoinUnitsTotalAmount(coinUnitName);
        }
        return totalHoldingMoney;
    }

    private int getCoinUnitsTotalAmount(final String coinUnitName) {
        return quantityOfCoins.get(coinUnitName) * Coin.valueOf(coinUnitName).getAmount();
    }

    private void pushIn(final Coin coin) {
        quantityOfCoins.put(coin.name(), quantityOfCoins.get(coin.name()) + 1);
    }

    private void pullOut(final Coin coin) {
        quantityOfCoins.put(coin.name(), quantityOfCoins.get(coin.name()) - 1);
    }
}
