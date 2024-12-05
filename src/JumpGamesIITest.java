import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class JumpGamesIITest {

    static class Solution {
        public int jump(int[] nums) {
            //nums[i]之和>nums[len-1]?yes:no
            int len=nums.length,count=0;
            //如果就一步或者没有，那直接成功
            if(len<2) return 0;
            //前n-1个元素能够跳到的最远距离
            int distance=0,end=0;
            //最后一个不计入，否则起跳多一次
            for(int i=0;i<len-1;i++){
                //第i个元素能够调到的最远距离
                int temp=i+nums[i];
                distance=Math.max(temp,distance);
                //如果跳到头了，就一定会起跳
                if(i==end){
                    end=distance;
                    count++;
                }
            }
            return count;
        }
    }

    // 输出输入信息
    public void printInput(int[] nums) {
        System.out.println("输入\n" + Arrays.toString(nums));
    }

    // 输出结果和预期结果
    public void printOutput(int result, int expected) {
        System.out.println("输出\n" + result + "\n预期结果\n" + expected);
    }

    private final Solution solution = new Solution();

    // 测试用例1：正常情况下
    @Test
    public void testJumpCase1() {
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例2：包含零的情况
    @Test
    public void testJumpCase2() {
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例3：单元素数组，跳跃次数为0
    @Test
    public void testJumpCase3() {
        int[] nums = {0};
        int expected = 0;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例4：数组每个元素都为1
    @Test
    public void testJumpCase4() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 4;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：大步跳跃的情况
    @Test
    public void testJumpCase5() {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int expected = 2;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：大步跳跃的情况
    @Test
    public void testJumpCase6() {
        int[] nums = {1,2,1,1,1};
        int expected = 3;
        printInput(nums);
        int result = solution.jump(nums);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}

