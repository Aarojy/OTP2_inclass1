import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ShoppingCartAppTest {

    @Test
    void calculateTotal() {
        double price = 19.99;
        int quantity = 3;
        double expectedTotal = 59.97;

        double actualTotal = ShoppingCartApp.calculateTotal(price, quantity);
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void calculateTotal_false() {
        double price = 19.99;
        int quantity = 3;
        double expectedTotal = 60.00;

        double actualTotal = ShoppingCartApp.calculateTotal(price, quantity);
        assertNotEquals(expectedTotal, actualTotal);
    }

    @Test
    void calculateTotal_ZeroQuantity() {
        double price = 19.99;
        int quantity = 0;
        double expectedTotal = 0.0;

        double actualTotal = ShoppingCartApp.calculateTotal(price, quantity);
        assertEquals(expectedTotal, actualTotal);
    }
}