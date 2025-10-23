import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Locale userLocale;

        System.out.print("Choose your preferred language (1. English, 2. Finnish, 3. Swedish, 4. Japanese): ");
        String userChoice = input.nextLine();

        String language;
        String country;

        switch (userChoice) {
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
        System.out.println();

        userLocale = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", userLocale);

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
    }

    public static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }
}
