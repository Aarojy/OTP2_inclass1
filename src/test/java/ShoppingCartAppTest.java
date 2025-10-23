import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
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

    @Test
    void fullApplicationTest_English() {
        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();

        String simulatedInput = "1\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(62.0, shoppingCartApp.runShop());
    }

    @Test
    void fullApplicationTest_Finnish() {
        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();

        String simulatedInput = "2\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(62.0, shoppingCartApp.runShop());
    }

    @Test
    void fullApplicationTest_Sweadish() {
        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();

        String simulatedInput = "3\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(62.0, shoppingCartApp.runShop());
    }

    @Test
    void fullApplicationTest_Japanese() {
        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();

        String simulatedInput = "4\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(62.0, shoppingCartApp.runShop());
    }

    @Test
    void fullApplicationTest_Default() {
        ShoppingCartApp shoppingCartApp = new ShoppingCartApp();

        String simulatedInput = "5\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(62.0, shoppingCartApp.runShop());
    }

    @Test
    void testMain() {
        Main mainApp = new Main();

        String simulatedInput = "5\n3\n10.0\n2\n5.5\n4\n20.0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        String[] args = {};
        mainApp.main(args);
    }

    @Test
    void testEnglishBundle() {
        ResourceBundle rb = ShoppingCartApp.setLanguage("1");
        assertEquals("Welcome!", rb.getString("greeting"));
        assertEquals("Enter the number of items to purchase:", rb.getString("number"));
        assertEquals("Enter the price for item:", rb.getString("price"));
        assertEquals("Enter the quantity for item:", rb.getString("quantity"));
        assertEquals("Total cost:", rb.getString("total_cost"));
    }

    @Test
    void testFinnishBundle() {
        ResourceBundle rb = ShoppingCartApp.setLanguage("2");
        assertEquals("Tervetuloa!", rb.getString("greeting"));
        assertEquals("Syötä ostettavien tuotteiden määrä:", rb.getString("number"));
        assertEquals("Syötä tuotteen hinta:", rb.getString("price"));
        assertEquals("Syötä tuotteen määrä:", rb.getString("quantity"));
        assertEquals("Kokonaishinta:", rb.getString("total_cost"));
    }

    @Test
    void testSwedishBundle() {
        ResourceBundle rb = ShoppingCartApp.setLanguage("3");
        assertEquals("Välkommen!", rb.getString("greeting"));
        assertEquals("Ange antalet varor att köpa:", rb.getString("number"));
        assertEquals("Ange priset för varan:", rb.getString("price"));
        assertEquals("Ange mängden varor:", rb.getString("quantity"));
        assertEquals("Total kostnad:", rb.getString("total_cost"));
    }

    @Test
    void testJapaneseBundle() {
        ResourceBundle rb = ShoppingCartApp.setLanguage("4");
        assertEquals("歓迎!", rb.getString("greeting"));
        assertEquals("購入する商品の数を入力してください:", rb.getString("number"));
        assertEquals("商品の価格を入力してください:", rb.getString("price"));
        assertEquals("商品の数量を入力してください:", rb.getString("quantity"));
        assertEquals("合計金額:", rb.getString("total_cost"));
    }
}