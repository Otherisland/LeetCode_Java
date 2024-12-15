import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoSumsIIInputArraysSortedTest {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] index = new int[2];
            int i=0,j=nums.length-1;
            while(i!=j){
                if(nums[i]+nums[j]<target) i++;
                else if(nums[i]+nums[j]>target) j--;
                else {
                    index[0] = i+1;
                    index[1] = j+1;
                    return index;
                }
            }
            return index;
        }
    }
    // 辅助方法，用于打印输入和输出
    private void printInput(int[] numbers, int target) {
        System.out.println("输入");
        System.out.println(Arrays.toString(numbers));
        System.out.println("target = " + target);
    }

    private void printOutput(int[] result,int [] expected) {
        System.out.println("输出");
        System.out.println(Arrays.toString(result));
        System.out.println("预期结果");
        System.out.println(Arrays.toString(expected));
    }

    // 测试用例1：普通的正整数情况
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int [] expected= new int []{1,2};
        printInput(numbers, target);
        int[] result = solution.twoSum(numbers, target);
        printOutput(result,expected);

        assertArrayEquals(expected, result);  // 预期结果是 [1, 2]
    }

    // 测试用例2：包含负数
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[] numbers = {-1, 0};
        int target = -1;
        int [] expected=new int[]{1, 2};
        printInput(numbers, target);
        int[] result = solution.twoSum(numbers, target);
        printOutput(result,expected);

        assertArrayEquals(expected, result);  // 预期结果是 [1, 2]
    }

    // 测试用例3：数组中存在大数和小数的情况
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[] numbers = {2, 3, 4};
        int target = 6;
        int [] expected=new int[]{1, 3};
        printInput(numbers, target);
        int[] result = solution.twoSum(numbers, target);
        printOutput(result,expected);

        assertArrayEquals(expected, result);  // 预期结果是 [1, 3]
    }

    // 测试用例4：包含重复元素的情况
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[] numbers = {1, 2, 2, 4};
        int target = 4;
        int [] expected=new int[]{2, 3};
        printInput(numbers, target);
        int[] result = solution.twoSum(numbers, target);
        printOutput(result,expected);

        assertArrayEquals(expected, result);  // 预期结果是 [1, 3]
    }

    // 测试用例5：较大的数组
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int[] numbers = {1, 3, 5, 7, 9, 11};
        int target = 10;
        int [] expected=new int[]{1, 5};
        printInput(numbers, target);
        int[] result = solution.twoSum(numbers, target);
        printOutput(result,expected);

        assertArrayEquals(expected, result);  // 预期结果是 [2, 5]
    }
}
