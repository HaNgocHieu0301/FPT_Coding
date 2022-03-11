
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    public static int menu() {
        System.out.println("FRUIT SHOP SYSTEM-");
        System.out.println("    1. Create Fruit");
        System.out.println("    2. Update Fruit");
        System.out.println("    3. View orders");
        System.out.println("    4. Shopping(for Buyer)");
        System.out.println("    5. Exit");
        int choice = Validation.getInt("Enter your choice: ", 1, 5);
        return choice;
    }

    public static void main(String[] args) {
        Management mag = new Management();
        boolean flag = true;
        while (flag) {
            switch (menu()) {
                case 1:
                    mag.createFruit(null);
                    break;
                case 2:
                    mag.updateFruit();
                    break;
                case 3:
                    mag.viewOrders();
                    break;
                case 4:
                    mag.shopping();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }

    }
}
