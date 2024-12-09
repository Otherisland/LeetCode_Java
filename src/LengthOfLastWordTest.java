import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LengthOfLastWordTest {

    static class Solution {
        public int lengthOfLastWord(String s) {
            int len=s.length(),wordLen=0;
            int index=len-1;
            //从后往前遍历，将空格跳过
            while(s.charAt(index)==' ') index--;
            //当s没有被遍历完
            while(index>=0&&s.charAt(index)!=' ') {
                wordLen++;
                index--;
            }
            return wordLen;
        }
    }
    // 输出输入信息
    public void printInput(String s) {
        System.out.println("输入");
        System.out.println("s=");
        System.out.println(s);
    }

    // 输出结果和预期结果
    public void printOutput(int result, int expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }
    // 测试用例1：正常的单词分隔
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "Hello World";
        int expected = 5;

        printInput(s);
        int result = solution.lengthOfLastWord(s);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例2：带有多余空格的输入
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "   fly me   to   the moon  ";
        int expected = 4;

        printInput(s);
        int result = solution.lengthOfLastWord(s);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例3：单个单词
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "luffy is still joyboy";
        int expected = 6;

        printInput(s);
        int result = solution.lengthOfLastWord(s);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例4：单个字母单词
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "a";
        int expected = 1;

        printInput(s);
        int result = solution.lengthOfLastWord(s);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：连续空格的输入
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String s = "    hello     ";
        int expected = 5;

        printInput(s);
        int result = solution.lengthOfLastWord(s);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}
