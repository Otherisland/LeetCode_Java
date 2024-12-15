import org.junit.Test;
import static org.junit.Assert.*;

public class IsSubsequenceTest {

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int n = s.length();
            int m = t.length();
            boolean isSubsequence = false;
            if(n==0) return !isSubsequence;
            if(m==0)return isSubsequence;
            for(int i=0,j=0;(i<n)&&(j<m);j++){
                //如果两者相同
                if(s.charAt(i)==t.charAt(j)) i++;
                //如果子串遍历完毕,证明有匹配的子串
                if(i==n) return !isSubsequence;
            }
            return isSubsequence;
        }
    }

    // 辅助方法，用于打印输入和输出
    private void printInput(String s, String t) {
        System.out.println("输入");
        System.out.println("s = \"" + s + "\"");
        System.out.println("t = \"" + t + "\"");
    }

    private void printOutput(boolean result,boolean expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：s 是 t 的子序列
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "abc";
        String t = "ahbgdc";
        boolean expected=true;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertTrue(result);  // 预期结果是 true
    }

    // 测试用例2：s 不是 t 的子序列
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "axc";
        String t = "ahbgdc";
        boolean expected=false;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertFalse(result);  // 预期结果是 false
    }

    // 测试用例3：s 是空字符串，t 是非空字符串
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "";
        String t = "ahbgdc";
        boolean expected=true;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertTrue(result);  // 预期结果是 true，因为空字符串是任何字符串的子序列
    }

    // 测试用例4：s 和 t 都是空字符串
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "";
        String t = "";
        boolean expected=true;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertTrue(result);  // 预期结果是 true，因为空字符串是任何字符串的子序列
    }

    // 测试用例5：t 是 s 的完全匹配
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String s = "abc";
        String t = "abc";
        boolean expected=true;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertTrue(result);  // 预期结果是 true，因为 t 就是 s
    }

    // 测试用例6：s 的长度大于 t 的长度
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String s = "abcdef";
        String t = "abc";
        boolean expected=false;
        printInput(s, t);
        boolean result = solution.isSubsequence(s, t);
        printOutput(result,expected);

        assertFalse(result);  // 预期结果是 false，因为 s 的长度大于 t
    }
}
