import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayTest {

    //26. Remove Duplicates from Sorted Array
    //方法实现
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int k = 1; // k 用来记录不重复的元素个数
            for (int i=1; i < nums.length; i++) {
                if(nums[i]!=nums[i-1]){ nums[k]=nums[i];k++;}
            }
            return k;
        }
    }
    Solution solution = new Solution();
    // 用于打印输入数据
    public void printInput(int[] nums) {
        System.out.println("输入\n" + Arrays.toString(nums));
    }

    // 用于打印输出数据
    public void printOutput(int[] nums, int [] excepted) {
        System.out.println("输出\n" + Arrays.toString(nums) + "\n预期结果\n" + Arrays.toString(excepted));
    }

    // 测试用例 1：正常情况，数组有重复元素
    @Test
    public void testRemoveDuplicatesCase1() {
        int[] nums = {1, 1, 2};
        int[] expectedNums = {1, 2}; // 预期结果是 [1, 2]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(2, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, expectedNums);
    }

    // 测试用例 2：大部分元素是重复的
    @Test
    public void testRemoveDuplicatesCase2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4}; // 预期结果是 [0, 1, 2, 3, 4]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, expectedNums);
    }

    // 测试用例 3：数组已经没有重复元素
    @Test
    public void testRemoveDuplicatesCase3() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expectedNums = {1, 2, 3, 4, 5}; // 预期结果是 [1, 2, 3, 4, 5]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, expectedNums);
    }

    // 测试用例 4：空数组
    @Test
    public void testRemoveDuplicatesCase4() {
        int[] nums = {};
        int[] expectedNums = {}; // 预期结果为空数组

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(0, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否为空
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, expectedNums);
    }

    // 测试用例 5：数组只有一个元素
    @Test
    public void testRemoveDuplicatesCase5() {
        int[] nums = {1};
        int[] expectedNums = {1}; // 预期结果是 [1]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(1, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, expectedNums);
    }
}
