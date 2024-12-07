import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ProductOfArrayExceptSelfTest {
    //必须是时间复杂度O(n)
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            //乘积前缀和后缀
            //ps:nums=[2,3,4,5]
            // prefix=[1,2,6,24]
            int [] prefix = new int[length];
            //   nums=[      5,4,3,2]
            // suffix=[      1,5,20,60]
            int [] suffix = new int[length];
            // prefix=[1,2,6,24]
            // suffix=[60,20,5,1]
            // results=[60,40,30,24]
            int [] results = new int[length];
            //结果数组初始化，置1
            prefix[0] = 1;
            //从左到右乘
            for (int i = 1; i < length; i++) prefix[i] = prefix[i - 1] * nums[i - 1];
            //从右到左乘
            suffix[length-1] = 1;
            for (int i = length - 2; i >= 0; i--) suffix[i] = suffix[i+1] * nums[i + 1];
            //前缀后缀相乘
            for(int i=0;i<length;i++) results[i] = prefix[i] * suffix[i];
            return results;
        }
    }

    // Helper method to print the input and output
    public void printInput(int[] nums) {
        System.out.println("输入");
        System.out.println(Arrays.toString(nums));
    }

    public void printOutput(int[] result) {
        System.out.println("输出");
        System.out.println(Arrays.toString(result));
    }

    Solution solution = new Solution();

    // Test case 1
    @Test
    public void testJumpCase1(){
        int[] nums = {1, 2, 3, 4};
        printInput(nums);
        int[] result = solution.productExceptSelf(nums);
        printOutput(result);
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, result);
    }

    // Test case 2
    @Test
    public void testJumpCase2(){
        int[] nums = {-1, 1, 0, -3, 3};
        printInput(nums);
        int[] result = solution.productExceptSelf(nums);
        printOutput(result);
        int[] expected = {0, 0, 9, 0, 0};
        assertArrayEquals(expected, result);
    }

    //Test case 3
    @Test
    public void testJumpCase3(){
        int[] nums = {1, 1};
        printInput(nums);
        int[] result = solution.productExceptSelf(nums);
        printOutput(result);
        int[] expected = {1, 1};
        assertArrayEquals(expected, result);
    }
}