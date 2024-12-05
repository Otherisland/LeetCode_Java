import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

//JUint测试单元
public class RemoveElementTest {
    //27. Remove Element
    //方法实现
    static class Solution{
        public int removeElement(int[] nums, int val) {
            int count=0;
            for(int i=0;i< nums.length;i++){
                //找到不同的变量
                if(nums[i]!=val){
                    nums[count++]=nums[i];
                }
            }
            return count;
        }
    }
    private final Solution solution=new Solution();

    public void printInput(int[] nums, int val) {
        System.out.println("输入\nnums1=\n"+ Arrays.toString(nums)+"\nval=\n"+val);
    }

    public void printOutput(int count,int[] nums, int expectedCount, int[] expected) {
        System.out.println("输出\n"+ count+"\nnums="+Arrays.toString(nums)+"\n预期结果\n"+ expectedCount+"\nnums="+Arrays.toString(expected));
    }

    @Test
    public void testRemoveElementCase1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] expectedNums = {2, 2}; // 预期结果不包含 3，顺序不重要
        printInput(nums,val);
        int k = solution.removeElement(nums, val);

        // 测试返回的 k 是否正确
        assertEquals(2, k);

        // 测试 nums 数组前 k 个元素是否是 expectedNums
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        Arrays.sort(actualNums);  // 排序后比较
        Arrays.sort(expectedNums);
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(k,actualNums,k,expectedNums);
    }

    @Test
    public void testRemoveElementCase2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int[] expectedNums = {0, 1, 3, 0, 4}; // 预期结果不包含 2，顺序不重要
        printInput(nums,val);

        int k = solution.removeElement(nums, val);

        // 测试返回的 k 是否正确
        assertEquals(5, k);

        // 测试 nums 数组前 k 个元素是否是 expectedNums
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        Arrays.sort(actualNums);  // 排序后比较
        Arrays.sort(expectedNums);
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(k,actualNums,k,expectedNums);
    }

    @Test
    public void testRemoveElementCase3() {
        int[] nums = {1, 1, 1, 1, 1};
        int val = 1;
        int[] expectedNums = {}; // 预期结果为空数组，因为所有元素都是 val
        printInput(nums,val);

        int k = solution.removeElement(nums, val);

        // 测试返回的 k 是否正确
        assertEquals(0, k);

        // 测试 nums 数组前 k 个元素是否为空
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(k,actualNums,k,expectedNums);
    }

    @Test
    public void testRemoveElementCase4() {
        int[] nums = {1, 2, 3, 4, 5};
        int val = 6; // val 不存在于数组中
        int[] expectedNums = {1, 2, 3, 4, 5}; // 结果应该是原数组，所有元素都保留
        printInput(nums,val);

        int k = solution.removeElement(nums, val);

        // 测试返回的 k 是否正确
        assertEquals(5, k);

        // 测试 nums 数组前 k 个元素是否和原数组相同
        int[] actualNums = Arrays.copyOf(nums, k); // 只考虑前 k 个元素
        assertArrayEquals(expectedNums, actualNums); // 验证结果
        printOutput(k,actualNums,k,expectedNums);
    }
}
