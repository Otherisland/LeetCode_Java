import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class SprialMatrixTest {

    //用数组记录是否访问过，或者top++,right++,left--,bottom--
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0)
                return new ArrayList<Integer>();
            int top=0,bottom=matrix.length-1;
            int left = 0, right = matrix[0].length - 1;
            int x = 0;
            Integer[] res = new Integer[(right + 1) * (bottom + 1)];
            //若矩阵为:
            // [1, 2, 3, 4]
            // [5, 6, 7, 8]
            // [9,10,11,12]
            // |   | 0->  ->  -> 3 | * |
            // |   |---------------| ↓ |
            // | 0 | *-> 0-> 1     | 1 |
            // | ↑ |---------------| ↓ |
            // | * | 0<- 1<- 2 <-* | 2 |
            while (true) {
                for (int i = left; i <= right; i++)
                    res[x++] = matrix[top][i]; // left to right
                if (++top > bottom) break;//转向上到下，若到头则结束
                for (int i = top; i <= bottom; i++)
                    res[x++] = matrix[i][right]; // top to bottom
                if (left > --right) break;//转向右到左，若到头则结束
                for (int i = right; i >= left; i--)
                    res[x++] = matrix[bottom][i]; // right to left
                if (top > --bottom) break;//转向下到上，若到头则结束
                for (int i = bottom; i >= top; i--)
                    res[x++] = matrix[i][left]; // bottom to top
                if (++left > right) break;//转向左到右，到头则结束
            }
            return Arrays.asList(res);
        }
    }

    // Method to print input
    public void printInput(int[][] matrix) {
        System.out.println("输入");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // Method to print output and expected results
    public void printOutput(List<Integer> result, List<Integer> expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    @Test
    public void testCase1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printInput(matrix);

        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    @Test
    public void testCase2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        printInput(matrix);

        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    @Test
    public void testCase3() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        printInput(matrix);

        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 4, 3);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    @Test
    public void testCase4() {
        int[][] matrix = {
                {1}
        };
        printInput(matrix);

        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1);
        printOutput(result, expected);

        assertEquals(expected, result);
    }
}
