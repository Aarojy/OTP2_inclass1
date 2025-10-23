import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

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

    @Test
    void setLanguage_English() {
        String choice = "1";
        String expectedLanguage = "en";
        String expectedCountry = "US";

        ResourceBundle rb = ShoppingCartApp.setLanguage(choice);
        Locale locale = rb.getLocale();

        assertEquals(expectedLanguage, locale.getLanguage());
        assertEquals(expectedCountry, locale.getCountry());
    }

    @Test
    void setLanguage_Finnish() {
        String choice = "2";
        String expectedLanguage = "fi";
        String expectedCountry = "FI";

        ResourceBundle rb = ShoppingCartApp.setLanguage(choice);
        Locale locale = rb.getLocale();

        assertEquals(expectedLanguage, locale.getLanguage());
        assertEquals(expectedCountry, locale.getCountry());
    }

    @Test
    void setLanguage_Swedish() {
        String choice = "3";
        String expectedLanguage = "sv";
        String expectedCountry = "SE";

        ResourceBundle rb = ShoppingCartApp.setLanguage(choice);
        Locale locale = rb.getLocale();

        assertEquals(expectedLanguage, locale.getLanguage());
        assertEquals(expectedCountry, locale.getCountry());
    }

    @Test
    void setLanguage_Japanese() {
        String choice = "4";
        String expectedLanguage = "ja";
        String expectedCountry = "JP";

        ResourceBundle rb = ShoppingCartApp.setLanguage(choice);
        Locale locale = rb.getLocale();

        assertEquals(expectedLanguage, locale.getLanguage());
        assertEquals(expectedCountry, locale.getCountry());
    }

    @Test
    void setLanguage_UnsupportedInput() {
        String choice = "5";
        String expectedLanguage = "en";
        String expectedCountry = "US";

        ResourceBundle rb = ShoppingCartApp.setLanguage(choice);
        Locale locale = rb.getLocale();

        assertEquals(expectedLanguage, locale.getLanguage());
        assertEquals(expectedCountry, locale.getCountry());
    }
}