import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    //方法一：自带api，方法二：暴力匹配，方法三：KMP算法

    //方法一：自带api
//    static class Solution {
//        public int strStr(String haystack, String needle) {
//            return haystack.indexOf(needle);
//        }
//    }

    //方法二：暴力匹配算法,主字符串和子字符串不匹配时都要退回
    //见ex_28.md(../handouts/ex_28.md)

    //方法三：KMP算法,主串字符串不用后退，直接向前走,例如
    //haystack:abaaaabaaabaacabaaba
    //  needle:abaaabaaba
    //①对子字符串needle进行前缀表初始化
    // 见KMP.md(../handouts/KMP.md)
    static class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            if (m == 0) {
                return 0;
            }
            int[] pi = new int[m];
            for (int i = 1, j = 0; i < m; i++) {
                while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = pi[j - 1];
                }
                if (needle.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                pi[i] = j;
            }
            for (int i = 0, j = 0; i < n; i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = pi[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return i - m + 1;
                }
            }
            return -1;
        }
    }

    // 输出输入信息
    public void printInput(String haystack, String needle) {
        System.out.println("输入\n");
        System.out.println("haystack = \""+haystack+"\", needle = \""+needle+"\"");
    }

    // 输出结果和预期结果
    public void printOutput(int result, int expected) {
        System.out.println("输出\n" + result + "\n预期结果\n" + expected);
    }

    // 测试用例1：needle 出现在 haystack 的最开始位置
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String haystack = "sadbutsad";
        String needle = "sad";
        int expect=0;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }

    // 测试用例2：needle 不存在于 haystack 中
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String haystack = "leetcode";
        String needle = "leeto";
        int expect=-1;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }

    // 测试用例3：needle 出现在 haystack 的中间位置
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String haystack = "sadbutsad";
        String needle = "but";
        int expect=3;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }

    // 测试用例4：needle 和 haystack 是相同的
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "hello";
        int expect=0;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }

    // 测试用例5：needle 是空字符串，应该返回 0
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String haystack = "any string";
        String needle = "";
        int expect=0;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }

    // 测试用例6：
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String haystack = "abaaaabaaabaacabaaca";
        String needle = "abaaabaaca";
        int expect=5;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }
    // 测试用例7：needle 长度大于 haystack
    @Test
    public void testCase7() {
        Solution solution = new Solution();
        String haystack = "needle";
        String needle = "haystackaaaaa";
        int expect=-1;

        printInput(haystack, needle);
        int result = solution.strStr(haystack, needle);
        printOutput(expect, result);
        assertEquals(expect, result);
    }
}
