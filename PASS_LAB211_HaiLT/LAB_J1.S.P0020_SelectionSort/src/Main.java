
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = getArray();
        displayArray(arr, "Unsorted Array: ");
        selectionSort(arr);
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

    private static int[] getArray() {
        int length = getInt("Enter the length of array: ", 0, Integer.MAX_VALUE);
        System.out.println("Enter range of input:");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getInt("", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return arr;
    }

    private static void displayArray(int[] arr, String msg) {
        System.out.print(msg);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            //find minimum number from list[i+1] to list[n-1]
            int minimum = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minimum]) {
                    minimum = j;
                }
            }
            //swap the above smallest number with list[i]
            if (i != minimum) {
                int tmp = list[i];
                list[i] = list[minimum];
                list[minimum] = tmp;
            }
        }
    }

}
