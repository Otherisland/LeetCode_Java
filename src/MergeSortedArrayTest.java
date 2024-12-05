import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

//JUint测试单元
public class MergeSortedArrayTest {
    //88. Merge Sorted Array
    //方法实现
    static class Solution{
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1=m-1, index2=n-1,index=m+n-1;
            while(index1>=0 && index2>=0){
                nums1[index--]=nums1[index1]>nums2[index2]?nums1[index1--]:nums2[index2--];
            }
            // 处理nums2剩余元素
            while (index2 >= 0) {
                nums1[index--] = nums2[index2--];
            }
        }
    }

    public void printInput(int[] nums1, int m,int[] nums2,int n) {
        System.out.println("输入\nnums1=\n"+ Arrays.toString(nums1)+"\nm=\n"+m+"\nnums2=\n"+Arrays.toString(nums2)+"\nn=\n"+n);
    }

    public void printOutput(int[] nums1,int[] expected){
        System.out.println("输出\n"+ Arrays.toString(nums1)+"\n预期结果\n"+Arrays.toString(expected));
    }

    private final Solution solution=new Solution();

    //测试用例1:：正常两数组排序
    @Test
    public void testMergeArraysCase1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        printInput(nums1, m, nums2, n);
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 2, 3, 5, 6};
        assertArrayEquals(expected, nums1);
        printOutput(nums1,expected);
    }

    // 测试用例2：nums2为空数组
    @Test
    public void testMergeArraysCase2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        printInput(nums1, m, nums2, n);
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1};
        assertArrayEquals(expected, nums1);
        printOutput(nums1,expected);
    }

    // 测试用例3：nums1为空数组
    @Test
    public void testMergeArraysCase3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        printInput(nums1, m, nums2, n);
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1};
        assertArrayEquals(expected, nums1);
        printOutput(nums1,expected);
    }


}

