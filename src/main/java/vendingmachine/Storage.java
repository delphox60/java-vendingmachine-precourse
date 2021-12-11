package vendingmachine;

import java.util.HashMap;

import constant.ErrorMessage;

public class Storage {
    private HashMap<String, Integer> priceInfo;
    private HashMap<String, Integer> stocks;

    public Storage() {
        priceInfo = new HashMap<>();
        stocks = new HashMap<>();
    }

    public void putProduct(final Product product) {
        priceInfo.put(product.getName(), product.getPrice());
        stocks.put(product.getName(), product.getStock());
    }

    public boolean checkPurchaseAble(final int inputAmount) {
        for (String productName : priceInfo.keySet()) {
            if (!isSoldOut(productName) && inputAmount >= getPrice(productName)) {
                return true;
            }
        }
        return false;
    }

    public void pullOut(final String productName, final int inputAmount) {
        if (getPrice(productName) > inputAmount) {
            System.out.println(ErrorMessage.INPUT_AMOUNT_SHORTAGE);
            throw new IllegalArgumentException();
        }
        if (isNotExist(productName)) {
            System.out.println(ErrorMessage.PRODUCT_IS_NOT_EXIST);
            throw new IllegalArgumentException();
        }
    }

    public int getPrice(final String productName) {
        return priceInfo.get(productName);
    }

    private boolean isNotExist(final String productName) {
        return priceInfo.get(productName) == null;
    }

    private boolean isSoldOut(final String productName) {
        if (stocks.get(productName) == 0) {
            return true;
        }
        return false;
    }
}
