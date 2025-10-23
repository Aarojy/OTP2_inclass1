import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCartApp {
    public double runShop() {
        Scanner input = new Scanner(System.in);

        System.out.print("Choose your preferred language:\n1. English\n2. Finnish (Suomi)\n3. Swedish (Svenska) \n4. Japanese (日本語)\n");
        String userChoice = input.nextLine();
        System.out.println();

        ResourceBundle rb = setLanguage(userChoice);

        System.out.println(rb.getString("greeting"));

        System.out.print(rb.getString("number")+ " ");
        int numberOfItems = Integer.parseInt(input.nextLine());

        double totalCost = 0.0;
        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(rb.getString("price") + " ");
            double price = Double.parseDouble(input.nextLine());

            System.out.print(rb.getString("quantity") + " ");
            int quantity = Integer.parseInt(input.nextLine());

            totalCost += calculateTotal(price, quantity);
            System.out.println();
        }

        System.out.println(rb.getString("total_cost")+ " " + totalCost);

        return totalCost;
    }

    public static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    public static ResourceBundle setLanguage(String choice) {
        Locale userLocale;
        String language;
        String country;

        switch (choice) {
            case "1":
                country = "US";
                language = "en";
                break;
            case "2":
                country = "FI";
                language = "fi";
                break;
            case "3":
                country = "SE";
                language = "sv";
                break;
            case "4":
                country = "JP";
                language = "ja";
                break;
            default:
                System.out.println("Unsupported input. Defaulting to English...");
                language = "EN";
                country = "US";
        }

        userLocale = new Locale(language, country);

        return ResourceBundle.getBundle("MessagesBundle", userLocale);
    }
}
