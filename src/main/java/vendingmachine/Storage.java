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
}
