import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIITest {

    //80. Remove Duplicates from Sorted Array II
    //方法实现
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len=nums.length;
            int count=2;//最终数组的长度
            if(len==0) return 0;
            else if(len==1) return 1;
            //前两个数肯定可以成立
            for(int i=2;i<len;i++){
                if(nums[i]!=nums[count-2]){
                    //如果相等就一定是第三个数了
                    nums[count++]=nums[i];
                }
            }
            return count;
        }
    }
    Solution solution = new Solution();
    // 这是我们需要测试的 removeDuplicates 方法实现

    // 用于打印输入数据
    public void printInput(int[] nums) {
        System.out.println("输入\n" + Arrays.toString(nums));
    }

    // 用于打印输出数据
    public void printOutput(int[] nums, int k,int[] excepted,int n) {
        System.out.println("输出\n" +"k="+k +"\n"+Arrays.toString(nums) +"\n预期结果\n" + Arrays.toString(excepted)+"\nn=\n"+n);
    }

    // 测试用例 1：正常情况，数组中有重复元素
    @Test
    public void testRemoveDuplicatesCase1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expectedNums = {1, 1, 2, 2, 3}; // 预期结果是 [1, 1, 2, 2, 3]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, k,expectedNums,5);
    }

    // 测试用例 2：重复元素较多
    @Test
    public void testRemoveDuplicatesCase2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] expectedNums = {0, 0, 1, 1, 2, 3, 3}; // 预期结果是 [0, 0, 1, 1, 2, 3, 3]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(7, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, k,expectedNums,7);
    }

    // 测试用例 3：数组长度小于等于 2，不需要修改
    @Test
    public void testRemoveDuplicatesCase3() {
        int[] nums = {1, 2};
        int[] expectedNums = {1, 2}; // 预期结果是 [1, 2]，原数组无需修改

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(2, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, k,expectedNums,2);
    }

    // 测试用例 4：只有一个元素
    @Test
    public void testRemoveDuplicatesCase4() {
        int[] nums = {1};
        int[] expectedNums = {1}; // 预期结果是 [1]

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(1, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否是唯一的
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, k,expectedNums,1);
    }

    // 测试用例 5：空数组
    @Test
    public void testRemoveDuplicatesCase5() {
        int[] nums = {};
        int[] expectedNums = {}; // 预期结果为空数组

        printInput(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(0, k); // 测试返回的 k 是否正确

        // 验证前 k 个元素是否为空
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(actualNums, k,expectedNums,0);
    }
}
