import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MajorityElementTest {

    //169. Majority Element
    //方法实现
    static class Solution {
        public int majorityElement(int[] nums) {
            //候选人投票算法
            int candidate = nums[0],count=1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==candidate){
                    count++;
                }else{
                    count--;
                }
                if(count==0){
                    candidate=nums[i];
                    count=1;
                }
            }
            return candidate;
        }
    }

    Solution solution = new Solution();

    public void printInput(int[] nums) {
        System.out.println("输入\nnums=\n"+ Arrays.toString(nums));
    }

    public void printOutput(int val,int expected){
        System.out.println("输出\n"+ val+"\n预期结果\n"+expected);
    }
    // 测试用例 1：普通示例，数组中 3 出现次数最多
    @Test
    public void testMajorityElementCase1() {
        int[] nums = {3, 2, 3};
        int expected = 3;
        printInput(nums);
        int result = solution.majorityElement(nums);
        assertEquals(expected, result); // 验证返回的多数元素是否正确
        printOutput(result, expected);
    }

    // 测试用例 2：数组中 2 出现次数最多
    @Test
    public void testMajorityElementCase2() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int expected = 2;

        printInput(nums);
        int result = solution.majorityElement(nums);
        assertEquals(expected, result); // 验证返回的多数元素是否正确
        printOutput(result, expected);
    }

    // 测试用例 3：只有一个元素
    @Test
    public void testMajorityElementCase3() {
        int[] nums = {1};
        int expected = 1;

        printInput(nums);
        int result = solution.majorityElement(nums);
        assertEquals(expected, result); // 验证返回的多数元素是否正确
        printOutput(result, expected);
    }

    // 测试用例 4：全相同元素
    @Test
    public void testMajorityElementCase4() {
        int[] nums = {7, 7, 7, 7, 7};
        int expected = 7;

        printInput(nums);
        int result = solution.majorityElement(nums);
        assertEquals(expected, result); // 验证返回的多数元素是否正确
        printOutput(result, expected);
    }

    // 测试用例 5：大规模数组
    @Test
    public void testMajorityElementCase5() {
        int[] nums = new int[50000];
        for (int i = 0; i < 25000; i++) {
            nums[i] = 1;
        }
        for (int i = 25000; i < 50000; i++) {
            nums[i] = 2;
        }
        int expected = 1;

        printInput(nums);
        int result = solution.majorityElement(nums);
        assertEquals(expected, result); // 验证返回的多数元素是否正确
        printOutput(result, expected);
    }

}
