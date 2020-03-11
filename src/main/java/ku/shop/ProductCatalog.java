package ku.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;
    private List<ProductAmount> productAmountList;

    public ProductCatalog() {
        products = new HashMap<>();
        productAmountList = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity) {
        boolean newProduct = true;
        for(ProductAmount pA: productAmountList) {
            if (pA.getProduct().getName().equals(name)) {
                pA.addAmount(quantity);
                newProduct = false;
            }
        }

        if (newProduct) {
            Product p = new Product(name, price);
            productAmountList.add(new ProductAmount(p, quantity));
//            p.setQuantity(quantity);
            products.put(name, p);
        }
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public boolean checkStock(Product prod, int quantity) {
        // return true if an amount of product in stock >= order quantity
        for (ProductAmount pA: productAmountList) {
            if (pA.getProduct().equals(prod)) {
                return pA.getAmount() >= quantity;
            }
        }
        return false;
    }
}
