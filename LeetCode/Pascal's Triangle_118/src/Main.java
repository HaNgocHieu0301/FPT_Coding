
import java.util.*;


/**
 *
 * @author HNH
 */

/*
    Given an integer numRows, return the first numRows of Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

    Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2:
    Input: numRows = 1
    Output: [[1]]

    Constraints:
    1 <= numRows <= 30
*/
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>(); //optimize way
        for(int i = 0; i < numRows; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < i+1 ; j++){
                if(j == 0 || j == i){
                    tmp.add(1);
                }else{
/*
--------------------------my way-----------------------------------
//                    int fnum = res.get(i-1).get(j-1);
//                    int snum = pre.get(i-1).get(j);
//                    tmp.add(fnum + snum);                    
*/ 
                    tmp.add(pre.get(j-1) + pre.get(j)); //optimize way
                }
            }
            res.add(tmp);
            pre = tmp; //optimize way
        }
        return res;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }

}
