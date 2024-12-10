import org.junit.Test;
import static org.junit.Assert.*;

public class ValidPalindromeTest {
    static class Solution {
        public boolean isPalindrome(String s) {
            //双指针 left和right，依次向中间集合
            int left = 0, right = s.length() - 1;
            //判断双指针是否重合，重合则结束
            while (left < right) {
                char l=checkChar(s.charAt(left));
                char r=checkChar(s.charAt(right));
                //判断是否为字母或数字
                if(l=='-'){
                    left++;
                    continue;
                }
                if(r=='-'){
                    right--;
                    continue;
                }
                if(l==r){
                    left++;
                    right--;
                    continue;
                }
                return false;
            }
            return true;
        }

        public static char checkChar(char c){
            if(c >='0' && c<='9') return c;
            if(c>='a' && c<='z') return (char)(c-'a'+'A');
            if(c>='A' && c<='Z') return c;
            return '-';
        }
    }

    // 辅助方法，用于打印输入和输出
    private void printInput(String s) {
        System.out.println("输入");
        System.out.println("s = \"" + s + "\"");
    }

    private void printOutput(boolean result) {
        System.out.println("输出");
        System.out.println(result);
    }

    // 测试用例1：标准回文字符串
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        printInput(s);
        boolean result = solution.isPalindrome(s);
        printOutput(result);

        assertTrue(result);  // 预期结果是 true
    }

    // 测试用例2：不是回文的字符串
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "race a car";
        printInput(s);
        boolean result = solution.isPalindrome(s);
        printOutput(result);

        assertFalse(result);  // 预期结果是 false
    }

    // 测试用例3：空字符串是回文
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = " ";
        printInput(s);
        boolean result = solution.isPalindrome(s);
        printOutput(result);

        assertTrue(result);  // 预期结果是 true
    }

    // 测试用例4：单字符字符串，回文
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "a";
        printInput(s);
        boolean result = solution.isPalindrome(s);
        printOutput(result);

        assertTrue(result);  // 预期结果是 true
    }

    // 测试用例5：只有数字的回文字符串
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String s = "12321";
        printInput(s);
        boolean result = solution.isPalindrome(s);
        printOutput(result);

        assertTrue(result);  // 预期结果是 true
    }
}
