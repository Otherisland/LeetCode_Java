import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class Sum3SumTest {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int k = 0; k < nums.length - 2; k++){
                if(nums[k] > 0) break;
                if(k > 0 && nums[k] == nums[k - 1]) continue;
                int i = k + 1, j = nums.length - 1;
                while(i < j){
                    int sum = nums[k] + nums[i] + nums[j];
                    if(sum < 0){
                        while(i < j && nums[i] == nums[++i]);
                    } else if (sum > 0) {
                        while(i < j && nums[j] == nums[--j]);
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while(i < j && nums[i] == nums[++i]);
                        while(i < j && nums[j] == nums[--j]);
                    }
                }
            }
            return res;
        }
    }

    Solution solution = new Solution();

    // 辅助方法，用于打印输入和输出
    private void printInput(int[] nums) {
        System.out.println("输入");
        System.out.println(Arrays.toString(nums));
    }

    private void printOutput(List<List<Integer>> result,List<List<Integer>> expected) {
        System.out.println("输出");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
        System.out.println("预期结果");
        for(List<Integer> triplet : expected) {
            System.out.println(triplet);
        }
    }

    // 测试用例1：包含多个符合条件的三元组
    @Test
    public void testCase1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );

        printInput(nums);
        List<List<Integer>> result = solution.threeSum(nums);
        printOutput(result, expected);

        // 预期结果是 [[-1, -1, 2], [-1, 0, 1]]
        assertEquals(expected, result);
    }

    // 测试用例2：没有符合条件的三元组
    @Test
    public void testCase2() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> expected = Arrays.asList(); // 预期结果是 []

        printInput(nums);
        List<List<Integer>> result = solution.threeSum(nums);
        printOutput(result, expected);

        // 预期结果是 []
        assertEquals(expected, result);
    }

    // 测试用例3：只有一个三元组符合条件
    @Test
    public void testCase3() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0, 0)
        );

        printInput(nums);
        List<List<Integer>> result = solution.threeSum(nums);
        printOutput(result, expected);

        // 预期结果是 [[0, 0, 0]]
        assertEquals(expected, result);
    }

    // 测试用例4：包含重复的元素
    @Test
    public void testCase4() {
        int[] nums = {-1, -1, 2, 2, 0, 0, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );

        printInput(nums);
        List<List<Integer>> result = solution.threeSum(nums);
        printOutput(result, expected);

        assertEquals(expected, result);
    }
}
