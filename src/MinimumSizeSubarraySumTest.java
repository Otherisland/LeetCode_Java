import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class MinimumSizeSubarraySumTest {

    static class Solution {

        // 方法：查找最小长度的子数组，其和大于等于目标值
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int left = 0;
            int sum = 0;
            int minLength = Integer.MAX_VALUE;

            for (int right = 0; right < n; right++) {
                sum += nums[right];
                // 当当前窗口的和大于等于目标值时，尝试缩小窗口
                while (sum >= target) {
                    minLength = Math.min(minLength, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }
    }


    // 辅助方法，用于打印输入数据
    private void printInput(int target, int[] nums) {
        System.out.println("输入");
        System.out.println("target = \n" + target);
        System.out.println("nums = \n" + Arrays.toString(nums));
    }

    // 辅助方法，用于打印输出和预期输出
    private void printOutput(int result, int expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：最小子数组的长度是2
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2; // 预期输出是 2，因为子数组 [4, 3] 的和 >= 7，且最小长度为 2

        printInput(target, nums);
        int result = solution.minSubArrayLen(target, nums);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例2：最小子数组的长度是1
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int target = 4;
        int[] nums = {1, 4, 4};
        int expected = 1; // 预期输出是 1，因为子数组 [4] 的和 >= 4，且最小长度为 1

        printInput(target, nums);
        int result = solution.minSubArrayLen(target, nums);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例3：没有符合条件的子数组
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 0; // 预期输出是 0，因为没有任何子数组的和 >= 11

        printInput(target, nums);
        int result = solution.minSubArrayLen(target, nums);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例4：有多个子数组符合条件，最小长度为 1
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int target = 6;
        int[] nums = {1, 2, 3};
        int expected = 3; // 预期输出是 2，因为子数组 [3, 2] 的和 >= 6，且最小长度为 2

        printInput(target, nums);
        int result = solution.minSubArrayLen(target, nums);
        printOutput(result, expected);

        assertEquals(expected, result);
    }
}
