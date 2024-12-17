import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class RotateImageTest {
    static class Solution {
        public void rotate(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[m - 1 - i][j];
                    matrix[m - 1 - i][j] = temp;
                }
            }
        }
    }

    Solution solution = new Solution();
    // Method to print the input matrix
    public void printInput(int[][] matrix) {
        System.out.println("输入");
        System.out.println(Arrays.deepToString(matrix));
    }

    // Method to print the output and expected result matrices
    public void printOutput(int[][] matrix, int[][] expected) {
        System.out.println("输出");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("预期结果");
        System.out.println(Arrays.deepToString(expected));
    }

    // Test case 1: Rotating the first example matrix
    @Test
    public void testCase1() {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected1 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        printInput(matrix1);
        solution.rotate(matrix1); // Rotate the matrix in place
        printOutput(matrix1, expected1); // Print the output and expected result
        assertArrayEquals(matrix1, expected1); // Verify the rotation is correct
    }

    // Test case 2: Rotating the second example matrix
    @Test
    public void testCase2() {
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected2 = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        printInput(matrix2);
        solution.rotate(matrix2); // Rotate the matrix in place
        printOutput(matrix2, expected2); // Print the output and expected result
        assertArrayEquals(matrix2, expected2); // Verify the rotation is correct
    }
}
