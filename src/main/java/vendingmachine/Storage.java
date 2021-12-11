package vendingmachine;

import java.util.HashMap;

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

    private int getPrice(final String productName) {
        return priceInfo.get(productName);
    }

    private boolean isSoldOut(final String productName) {
        if (stocks.get(productName) == 0) {
            return true;
        }
        return false;
    }
}
