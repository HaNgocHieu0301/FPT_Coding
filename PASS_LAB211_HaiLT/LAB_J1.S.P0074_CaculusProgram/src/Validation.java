
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    public static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg1, String msg2, int min, int max) {
        while (true) {
            System.out.print(msg1);
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    System.out.println("Input must be larger " + min + " and less than " + max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println(msg2);
            }
        }
    }
    
    public static int menu() {
        System.out.println("========Caculator program========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Exit.");
        return Validation.getInt("Your choice: ", "Input is invalid!", 1, 4);
    }
}
