
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = getArray();
        displayArray(arr, "Unsorted Array: ");
        bubbleSort(arr);
        displayArray(arr, "Sorted Array: ");
    }

    private static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input < min || input > max) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.out.println("The input isn't valid!!!");
                System.out.println("Enter again:");
            }
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }

    private static int[] getArray() {
        int length = getInt("Enter the length of array: ", 0, Integer.MAX_VALUE);
        System.out.println("Enter range of input:");
        int min = getInt("\tThe minimum number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int max = 0;
        while(true){
            max = getInt("\tThe maximum number: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if(max >= min){
                break;
            }
        }        
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getRandomNumberInRange(min, max);
        }
        return arr;
    }

    private static void displayArray(int[] arr, String msg) {
        System.out.print(msg);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
