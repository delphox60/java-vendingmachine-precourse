package vendingmachine.domain;

public class Product {

    private final String name;
    private final int price;
    private int stock;

    public Product(final String name, final int price, final int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isBuyAble(final int insertAmount) {
        if (stock == 0 || price > insertAmount) {
            return false;
        }
        return true;
    }

    public void pullOut() {
        stock--;
    }
}