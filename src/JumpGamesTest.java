import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;



public class JumpGamesTest {

    static class Solution {
        public boolean canJump(int[] nums) {
            //nums[i]之和>nums[len-1]?yes:no
            int len=nums.length;
            //如果就一步或者没有，那直接成功
            if(len<2) return true;
            //储存每格的位置
            return false;
        }


    }

    // 输出输入信息
    public void printInput(int[] nums) {
        System.out.println("输入");
        System.out.println("nums=");
        System.out.println(Arrays.toString(nums));
    }

    // 输出结果和预期结果
    public void printOutput(boolean result, boolean expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    private final Solution solution = new Solution();

    // 测试用例1：能跳到最后
    @Test
    public void testCanJumpCase1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean expected = true;
        printInput(nums);
        boolean result = solution.canJump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例2：不能跳到最后
    @Test
    public void testCanJumpCase2() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean expected = false;
        printInput(nums);
        boolean result = solution.canJump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例3：数组只有一个元素，始终可以到达
    @Test
    public void testCanJumpCase3() {
        int[] nums = {0};
        boolean expected = true;
        printInput(nums);
        boolean result = solution.canJump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例4：较大跳跃的情况
    @Test
    public void testCanJumpCase4() {
        int[] nums = {4, 0, 0, 0, 0};
        boolean expected = true;
        printInput(nums);
        boolean result = solution.canJump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：无法从起始位置跳跃
    @Test
    public void testCanJumpCase5() {
        int[] nums = {1, 0, 0, 0, 0};
        boolean expected = false;
        printInput(nums);
        boolean result = solution.canJump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}
