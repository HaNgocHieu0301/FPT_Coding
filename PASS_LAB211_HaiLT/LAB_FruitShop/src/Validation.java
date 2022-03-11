
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        while (true) {
            int res;
            try {
                System.out.print(msg);
                res = Integer.parseInt(sc.nextLine());
                if (res < min || res > max) {
                    System.out.print("Input must be a integer in range " + min + " to " + max);
                    continue;
                }
                return res;
            } catch (Exception e) {
                System.out.println("The input is invalid.");
            }
        }
    }

    public static double getDouble(String msg, double min, double max) {
        //double res = -1;
        while (true) {
            System.out.print(msg);
            try {
                double res = Double.parseDouble(sc.nextLine());
                if (res < min || res > max) {
                    System.out.println("Input must be a real number in range " + min + " to " + max);
                    continue;
                }
                return res;
            } catch (Exception e) {
                System.out.println("The input is invalid.");
                System.out.println("Please enter again: ");
            }
        }
    }

    public static String getString(String msg) {
        while (true) {
            String res;
            System.out.print(msg);
            res = sc.nextLine().trim();
            if (res.isEmpty()) {
                System.out.println("Input cannot be blank.");
            } else {
                return res;
            }
        }
    }

    public static boolean isContinue(String msg) {
        System.out.print(msg);
        do {
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid! Please user enters the choice again: ");
            }
        } while (true);
    }
}
