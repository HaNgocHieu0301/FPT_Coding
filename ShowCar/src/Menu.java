
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Menu {

    public int int_getChoice(ArrayList<String> opts) {
        Scanner sc = new Scanner(System.in);
        int res;
        for (int i = 0; i < opts.size(); i++) {
            System.out.println((i + 1) + ". " + opts.get(i));
        }
        while(true){
            try {
                System.out.print("Please choose an option 1..n: ");
                res = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid!");
            }
        }
        return res;
    }
    
    public int int_getChoice(BrandList opts) {
        Scanner sc = new Scanner(System.in);
        int res;
        for (int i = 0; i < opts.size(); i++) {
            System.out.println((i + 1) + ". " + opts.get(i));
        }
        while(true){
            try {
                System.out.print("Please choose an option 1..n: ");
                res = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid!");
            }
        }
        return res;
    }

    public Brand ref_getChoice(BrandList opts) {
        int response;
        int n = opts.size();
        do {
            response = int_getChoice(opts);
        } while (response < 0 || response > n);
        return opts.get(response - 1);

    }
}
