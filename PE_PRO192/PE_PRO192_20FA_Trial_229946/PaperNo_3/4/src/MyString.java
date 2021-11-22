
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class MyString implements IString {

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int f1(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (isPrime(Integer.parseInt("" + str.charAt(i)))) {
                    count++;
                }
            }
        }
        return count;
    }

    public String reverseWord(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }

    @Override
    public String f2(String src) {
        
        //cach tu lam
//        String result = "";
//        String[] lst = str.split("\\s+");
//        for(int i = lst.length - 1; i >= 0; i--){
//            result += lst[i] + " ";
//        }
//        return result.trim();

        //output 1 theo de
//        StringTokenizer stk = new StringTokenizer(str, " ");
//        String result = "";
//        while (stk.hasMoreTokens()) {
//            result = stk.nextToken() + " " + result;
//        }
//        return result;

        //output 2
//        StringTokenizer stk = new StringTokenizer(str, " ");
//        String result = "";
//        while (stk.hasMoreTokens()) {
//            result = stk.nextToken() + " " + result;
//        }
//        char[] clst = result.toCharArray();
//        String newResult = "";
//        for (int i = 0; i < clst.length; i++) {
//            if (!Character.isDigit(clst[i])) {
//                newResult += clst[i];
//            }
//        }
//        return newResult.trim();

        //output 3
//        StringTokenizer stk = new StringTokenizer(str, " ");
//        String result = "";
//        while (stk.hasMoreTokens()) {
//            result = reverseWord(stk.nextToken()) + " " + result;
//        }
//        return result;

        //output 4
        //Input2: a93 b15 a8b7 a7n32 a6k65 a5p135
        //Output2: 135 93 65 (tìm ra 3 words có chứa số lớn nhất, sắp theo thứ tự giảm dần)
                src = src.replaceAll("[^0-9]+", " ").trim();
        String[] lst = src.split("\\s+");
        List<Integer> nlst = new ArrayList<>();
        for (int i = 0; i < lst.length; i++) {
            nlst.add(Integer.parseInt(lst[i]));
        }
        nlst.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //To change body of generated methods, choose Tools | Templates.
            }
        });
//        System.out.println(nlst.get(0));
//        System.out.println(nlst.get(1));
//        System.out.println(nlst.get(2));
        return ""+nlst.get(0)+" "+nlst.get(1)+" "+nlst.get(2);
    }

}
