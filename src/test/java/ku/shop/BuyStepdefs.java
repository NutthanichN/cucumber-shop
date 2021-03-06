package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("(.+) of product (.+) with price (.+) exists")
    public void a_product_with_price_exists(int quantity, String name, double price) {
        catalog.addProduct(name, price, quantity);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant, catalog);
    }

    @When("I buy (.+) of (.+) My order is cancelled")
    public void i_buy_with_quantity_my_order_is_cancelled(int quant, String name) {
        Product prod = catalog.getProduct(name);
        assertThrows(IllegalArgumentException.class, () -> order.addItem(prod, quant, catalog));
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

}

