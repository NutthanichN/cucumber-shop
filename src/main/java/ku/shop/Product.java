package ku.shop;

public class Product {
    private double price;
    private String name;
    private int quantity;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be not be negative zero");
        }
        this.quantity = quantity;
    }
}
