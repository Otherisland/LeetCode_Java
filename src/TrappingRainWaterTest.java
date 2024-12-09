import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TrappingRainWaterTest {
    //对于任何一个位置,接水高度等于左边最高的柱子减去右边最高的柱子
    static class Solution {
        public int trap(int[] height) {
            int length = height.length,sum=0;
            int[] leftMax = new int[length];
            int[] rightMax = new int[length];
            int[] water=new int[length];
            leftMax[0] = height[0];
            rightMax[length - 1] = height[length - 1];
            //如果不超过三个,不蓄水
            if(length<3) return 0;
            //找每列左边最高的柱子
            for (int i = 1; i < length; i++)
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            //找每列右边最高的柱子
            for (int i = length - 2; i >= 0; i--)
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            //计算结果
            for(int i = 0; i <length; i++){
                water[i]=Math.min(leftMax[i],rightMax[i])-height[i];
                sum=sum+water[i];
            }
            return sum;
        }
    }

    // 测试用例1：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 6

        assertEquals(6, result); // 预期结果是 6
    }

    // 测试用例2：height = [4,2,0,3,2,5]
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[] height = {4,2,0,3,2,5};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 9

        assertEquals(9, result); // 预期结果是 9
    }

    // 测试用例3：height = [1,0,1]
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[] height = {1,0,1};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 1

        assertEquals(1, result); // 预期结果是 1
    }

    // 测试用例4：height = [3,2,1,2,1,5]
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[] height = {3,2,1,2,1,5};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 6

        assertEquals(6, result); // 预期结果是 8
    }

    // 测试用例5：height = [0, 0, 0, 0]
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int[] height = {0, 0, 0, 0};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 0

        assertEquals(0, result); // 预期结果是 0
    }

    // 测试用例6：height = [5, 4, 3, 2, 1]
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        int[] height = {5, 4, 3, 2, 1};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 0

        assertEquals(0, result); // 预期结果是 0
    }

    // 测试用例7：height = [1,2,3,4,5,6]
    @Test
    public void testCase7() {
        Solution solution = new Solution();
        int[] height = {1, 2, 3, 4, 5, 6};

        System.out.println("输入");
        System.out.println("height = " + Arrays.toString(height));

        int result = solution.trap(height);

        System.out.println("输出");
        System.out.println(result);  // 0

        assertEquals(0, result); // 预期结果是 0
    }
}
