
/**
 *
 * @author ADMIN
 */
public class Caculus {

    public int[][] getMatrix(int a, int b, int k) {
        int n = 0, m = 0;
        if (a == 0 && b == 0) {
            n = Validation.getInt("Enter Row Matrix " + k + ": ", "The input is invalid!", 0, Integer.MAX_VALUE);
            m = Validation.getInt("Enter Column Matrix" + k + ": ", "The input is invalid!", 0, Integer.MAX_VALUE);
        } else if (a != 0 && b == 0) {
            n = Validation.getInt("Enter Row Matrix "+k, "The input is invalid!", a, a);
//            System.out.println("Enter Row Matrix " + k + ": " + n);    
            m = Validation.getInt("Enter Column Matrix " + k + ": ", "The input is invalid!", 0, Integer.MAX_VALUE);     
        } else {
            n = Validation.getInt("Enter Row Matrix "+k, "The input is invalid!", a, a);
            m = Validation.getInt("Enter Column Matrix "+k, "The input is invalid!", b, b);
//            System.out.println("Enter Row Matrix " + k + ": " + n);
//            System.out.println("Enter Column Matrix " + k + ": " + m);
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = Validation.getInt("Enter Maxtrix" + k + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ",
                        "Values of matrix must be the number.",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return res;
    }

    public int[][] additionMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                newMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return newMatrix;
    }

    public int[][] subtractionMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i][j] = a[i][j] - b[i][j];
            }
        }
        return newMatrix;
    }

    public int[][] multiplicationMatrix(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for(int k = 0; k < b.length; k++){
                    newMatrix[i][j] += (a[i][k]*b[k][j]);
                }
            }
        }
        return newMatrix;
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

    public void displayMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("[" + a[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public void displayResult(int[][] a, int[][] b, char s){
        System.out.println("-------Result-------");
        displayMatrix(a);
        System.out.println(s);
        displayMatrix(b);
        System.out.println("=");
        if(s == '+'){
            displayMatrix(additionMatrix(a, b));
        }else if(s == '-'){
            displayMatrix(subtractionMatrix(a, b));
        }else if(s == '*'){
            displayMatrix(multiplicationMatrix(a, b));
        }
    }
}
