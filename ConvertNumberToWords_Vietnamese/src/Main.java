import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertNumToWords test = new ConvertNumToWords();
        System.out.println(test.convert(1011012023l).trim());
    } 
}
