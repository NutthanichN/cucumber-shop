package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        boolean newProduct = true;
        for (Map.Entry<String, Product> productEntry : products.entrySet()) {
            if (productEntry.getKey().equals(name)) {
                Product p = productEntry.getValue();
                p.setQuantity(p.getQuantity() + quantity);
                newProduct = false;
            }
        }

        if (newProduct) {
            Product p = new Product(name, price);
            p.setQuantity(quantity);
            products.put(name, p);
        }
    }

    public Product getProduct(String name) {
        return products.get(name);
    }
}
