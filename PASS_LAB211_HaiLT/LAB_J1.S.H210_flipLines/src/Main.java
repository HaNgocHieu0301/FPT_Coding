
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException{
        File source = new File("H210_flipLines.txt");
        //E:\\FPT_LearningCurriculum\\SEMESTER_3\\LAB\\Netbeans\\LAB_J1.S.H210_flipLines\\
        Scanner file = new Scanner(source);
        if (checkFile(source)) {
            flipLines(file);
        }
    }

    private static void flipLines(Scanner file) {
        //using arraylist to contains each line
        ArrayList<String> arr = new ArrayList<>();
        
        while (file.hasNext()) {
            arr.add(file.nextLine());
        }

        int length;
        //check
        if (arr.size() % 2 == 0) {
            length = arr.size();
        } else {
            length = arr.size() - 1;
        }
        for (int i = 0; i < length - 1; i += 2) {
            Collections.swap(arr, i, i + 1);
        }
        for(String x : arr){
            System.out.println(x);
        }
        file.close();
    }

    private static boolean checkFile(File file) {
        if (!file.exists()) {
            System.err.println("Not found!");
            return false;
        } else if (!file.canRead()) {
            System.err.println("File cannot read.");
            return false;
        }
        return true;
    }
    
    
}
