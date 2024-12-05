import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//189. Rotate Array
//方法实现1
class SolutionA extends RotateArrayTest.Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        //判断是否为特殊情况
        if (len == 0 || k % len == 0) {
            return;
        }
        //得出旋转的余数
        int[] temp = new int[nums.length];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        //将数组temp赋值给nums并返回
        System.arraycopy(temp, 0, nums, 0, len);
    }
}
//方法实现2
class SolutionB extends RotateArrayTest.Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //判断是否为特殊情况
        if (n == 0 || k % n == 0) {
            return;
        }
        k %= n; // 轮转 k 次等于轮转 k%n 次
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}

@RunWith(Parameterized.class)
public class RotateArrayTest {

    private final Solution solution;

    public RotateArrayTest(Solution solution) {
        this.solution = solution;
    }

    @Parameterized.Parameters
    public static Collection<Solution> solutions() {
        // 返回不同的 Solution 实现
        return Arrays.asList(
                new SolutionA(),
                new SolutionB()
        );
    }
    static class Solution {
        public void rotate(int[] nums, int k) {}
    }
    // 打印输入和输出数组的方法
    private void printInput(int[] nums, int k) {
        System.out.println("输入\nnums=\n" + Arrays.toString(nums) + "\nk=\n" + k);
    }

    private void printOutput(int[] nums, int[] expected) {
        System.out.println("输出\n" + Arrays.toString(nums) + "\n预期输出\n" + Arrays.toString(expected));
    }

    // 测试用例 1：数组向右旋转 3 步
    @Test
    public void testRotateCase1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {5, 6, 7, 1, 2, 3, 4};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }

    // 测试用例 2：数组向右旋转 2 步
    @Test
    public void testRotateCase2() {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        int[] expected = {3, 99, -1, -100};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }

    // 测试用例 3：旋转 0 步
    @Test
    public void testRotateCase3() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 0;
        int[] expected = {1, 2, 3, 4, 5};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }

    // 测试用例 4：旋转超过数组长度
    @Test
    public void testRotateCase4() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 7; // 7 旋转等同于 7 % 5 = 2
        int[] expected = {4, 5, 1, 2, 3};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }

    // 测试用例 5：数组长度为 1
    @Test
    public void testRotateCase5() {
        int[] nums = {10};
        int k = 3; // 旋转 3 步，结果应保持不变
        int[] expected = {10};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }

    // 测试用例 6：数组为空
    @Test
    public void testRotateCase6() {
        int[] nums = {};
        int k = 2;
        int[] expected = {};

        printInput(nums, k);
        solution.rotate(nums, k);
        assertArrayEquals(expected, nums);
        printOutput(nums, expected);
    }
}
