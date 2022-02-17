
import java.util.*;

/**
 *
 * @author ADMIN
 */
class Solution {

    public boolean isValidSudoku(String[][] board) {
        HashSet<String> hs = new HashSet<>();
        HashSet<String> hs2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != "." && !hs.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != "." && !hs2.add(board[j][i])) {
                    return false;
                }
            }
            hs.clear();
            hs2.clear();
        }
        hs.clear();
        int count = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j++) {
                for(int k = i; k < i+3; k++){
                    if(board[k][j] != "." && !hs.add(board[k][j])){
                        return false;
                    }
                }
                count++;
                if(count == 3){
                    count = 0;
                    hs.clear();
                }
            }
            hs.clear();
        }
        return true;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] c =
        {
            {"5","3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
            {".","9","8",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
            {"4",".",".","8",".","3",".",".","1"},
            {"7",".",".",".","2",".",".",".","6"},
            {".","6",".",".",".",".","2","8","."},
            {".",".",".","4","1","9",".",".","5"},
            {".",".",".",".","8",".",".","7","9"},
        }              
                ;
        System.out.println(s.isValidSudoku(c));
    }

}
