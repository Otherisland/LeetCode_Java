import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ValidSudokuTest {
    //note:合法即可，无需有解
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            int size = 9;
            //每行
            int[] rows = new int[size];
            //每列
            int[] columns = new int[size];
            //每个九宫格
            int[] boxs = new int[size];
            //遍历数独板
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    char val = board[i][j];
                    //若不为空，为空则跳过
                    if (val != '.') {
                        //获得当前格子内的数字，表示把1向左挪(val-'0')位
                        //为了位运算
                        int index = 1 << (val - '0');
                        //九宫格编号对应的格子数
                        int boxNum = (i / 3) * 3 + j / 3;
                        //位运算，若有相同的数，则返回非
                        if ((rows[i] & index) != 0 || (columns[j] & index) != 0
                                || (boxs[boxNum] & index) != 0) {
                            return false;
                        }
                        //位的或运算得到该行哪个数已经有了
                        rows[i] |= index;
                        columns[j] |=  index;
                        boxs[boxNum] |=  index;
                    }
                }
            }
            return true;
        }
    }

    private Solution solution = new Solution();

    // 用于输出格式化的输入输出
    public void printInput(char[][] board) {
        System.out.println("输入");
        System.out.print("[");
        for (int i=0;i<board.length-1;i++) {
            char[] row=board[i];
            System.out.println(Arrays.toString(row));
        }
        System.out.println(Arrays.toString(board[board.length-1])+"]");
    }

    public void printOutput(boolean result, boolean expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    @Test
    public void testCase1() {
        // 测试1：有效的数独棋盘
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        printInput(board);
        boolean expected = true;
        boolean result = solution.isValidSudoku(board);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testCase2() {
        // 测试2：无效的数独棋盘
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        printInput(board);
        boolean expected = false;
        boolean result = solution.isValidSudoku(board);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testCase3() {
        // 测试3：有效的数独棋盘
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printInput(board);
        boolean expected = true;
        boolean result = solution.isValidSudoku(board);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    @Test
    public void testCase4() {
        // 测试4：数独棋盘中有重复元素
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printInput(board);
        boolean expected = true;
        boolean result = solution.isValidSudoku(board);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}
