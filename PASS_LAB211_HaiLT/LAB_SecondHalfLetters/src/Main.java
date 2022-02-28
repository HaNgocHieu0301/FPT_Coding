import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        String input = getInput("Please enter the string:");
        System.out.println("The number of letters in second half alphabet is: " 
                + countSecondHalfLetters(input.toLowerCase()));
    }

    private static String getInput(String msg) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(msg);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!!");
                continue;
            }
            return input;
        } while (true);
    }

    private static int countSecondHalfLetters(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) <= 'z' && input.charAt(i) >= 'n') {
                count++;
            }
        }
        return count;
    }

}
