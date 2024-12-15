import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    static class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int currentArea=(right-left)*Math.min(height[left], height[right]);
                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
                if(height[left] < height[right]) left++;
                else right--;
            }
            return maxArea;
        }
    }
    // 辅助方法，用于打印输入和输出
    private void printInput(int[] height) {
        System.out.println("输入");
        System.out.println("height= ");
        System.out.println(Arrays.toString(height));
    }

    private void printOutput(int result,int expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：普通的数组
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        printInput(height);
        int expected=49;
        int result = solution.maxArea(height);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例2：数组中只有两个元素
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[] height = {1, 1};
        printInput(height);
        int expected=1;
        int result = solution.maxArea(height);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例3：极大和极小的高度差
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[] height = {10, 1, 10};
        printInput(height);
        int expected=20;
        int result = solution.maxArea(height);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例4：高度单调递增的情况
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[] height = {1, 2, 3, 4, 5};
        printInput(height);
        int expected=6;
        int result = solution.maxArea(height);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例5：高度单调递减的情况
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int[] height = {5, 4, 3, 2, 1};
        printInput(height);
        int expected=6;
        int result = solution.maxArea(height);
        printOutput(result,expected);
        assertEquals(expected, result);
    }
}
