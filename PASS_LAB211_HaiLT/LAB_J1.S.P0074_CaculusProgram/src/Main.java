
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        Caculus c = new Caculus();
        while (true) {
            int choice = Validation.menu();
            int[][] a = c.getMatrix(0, 0, 1);
            switch (choice) {
                case 1:
                    int[][] b1 = c.getMatrix(a.length, a[0].length, 2);
                    c.displayResult(a, b1, '+');
                    break;
                case 2:
                    int[][] b2 = c.getMatrix(a.length, a[0].length, 2);
                    c.displayResult(a, b2, '-');
                    break;
                case 3:
                    int[][] b3 = c.getMatrix(a[0].length, 0, 2);
                    c.displayResult(a, b3, '*');
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
        /*
        2 3 4   
        1 2 3 
        
        2 3 4
        1 3 5
        5 6 7
    
        27 39 51
        19 27 35
        
    */
}
