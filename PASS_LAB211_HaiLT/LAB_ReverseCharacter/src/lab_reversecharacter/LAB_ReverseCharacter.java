package lab_reversecharacter;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class LAB_ReverseCharacter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = getInput("Enter input: ");
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        System.out.println(res);
    }

    private static String getInput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String input = sc.nextLine();
        if (input.trim().isEmpty()) {
            System.out.println("Input is empty!");
            System.exit(0);
        }
        return input;
    }

}
