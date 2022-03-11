package Entity;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Cannot be blank.");
                continue;
            }
            return input;
        }
    }

    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            int input;
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    System.out.println("The input must be in range from " + min + " to " + max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Input invaild");
            }
        }
    }

    static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            double input;
            try {
                input = Double.parseDouble(sc.nextLine());
                if (input < min || input > max) {
                    System.out.println("The input must be in range from " + min + " to " + max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Input invaild");
            }
        }
    }
}
