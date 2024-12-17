import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringTest {
    //和SubstringWithConcatenationOfAllWordsTest ex_30类似
    static class Solution {
        public String minWindow(String S, String t) {
            char[] s = S.toCharArray();
            int m = s.length;
            //最短子串的左指针和右指针
            int ansLeft = -1;
            int ansRight = m;
            int[] cnt = new int[128];
            int less = 0;
            //如果有没出现过的字母，则记录
            for (char c : t.toCharArray()) {
                if (cnt[c] == 0) {
                    less++; // 有 less 种字母的出现次数 < t 中的字母出现次数
                }
                cnt[c]++;
            }

            int left = 0;
            for (int right = 0; right < m; right++) { // 移动子串右端点
                char c = s[right]; // 右端点字母
                cnt[c]--; // 右端点字母移入子串
                //如果该类型字母已经移入子串，类型记录减1
                if (cnt[c] == 0) {
                    // 原来窗口内 c 的出现次数比 t 的少，现在一样多
                    less--;
                }
                //如果都已经移入子串，缩短左指针的子串，直到找到把最左符合要求的字符移除
                while (less == 0) { // 涵盖：所有字母的出现次数都是 >=
                    if (right - left < ansRight - ansLeft) { // 找到更短的子串
                        ansLeft = left; // 记录此时的左右端点
                        ansRight = right;
                    }
                    char x = s[left]; // 左端点字母
                    //如果该类型的已经被移除了，则less++
                    if (cnt[x] == 0) {
                        // x 移出窗口之前，检查出现次数，
                        // 如果窗口内 x 的出现次数和 t 一样，
                        // 那么 x 移出窗口后，窗口内 x 的出现次数比 t 的少
                        less++;
                    }
                    cnt[x]++; // 左端点字母移出子串
                    left++;
                }
            }
            return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
        }
    }

    // 辅助方法，用于打印输入数据
    private void printInput(String s, String t) {
        System.out.println("输入");
        System.out.println("s = \"" + s + "\"");
        System.out.println("t = \"" + t + "\"");
    }

    // 辅助方法，用于打印输出和预期输出
    private void printOutput(String result, String expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：s = "ADOBECODEBANC"，t = "ABC"，预期输出是 "BANC"
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC"; // 预期输出是 "BANC"

        printInput(s, t);
        String result = solution.minWindow(s, t);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例2：s = "a"，t = "a"，预期输出是 "a"
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "a";
        String t = "a";
        String expected = "a"; // 预期输出是 "a"

        printInput(s, t);
        String result = solution.minWindow(s, t);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例3：s = "a"，t = "aa"，预期输出是 ""
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "a";
        String t = "aa";
        String expected = ""; // 预期输出是 ""

        printInput(s, t);
        String result = solution.minWindow(s, t);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例4：s = "ADOBECODEBANC"，t = "ABCB"，预期输出是 "BECODEBA"
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABCB";
        String expected = "BECODEBA"; // 预期输出是 "BECODEBA"

        printInput(s, t);
        String result = solution.minWindow(s, t);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

}
