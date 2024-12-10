import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TextJustificationTest {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<String>();
            int right = 0, n = words.length;
            while (true) {
                int left = right; // 当前行的第一个单词在 words 的位置
                int sumLen = 0; // 统计这一行单词长度之和
                // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
                while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                    sumLen += words[right++].length();
                }

                // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
                if (right == n) {
                    StringBuffer sb = join(words, left, n, " ");
                    sb.append(blank(maxWidth - sb.length()));
                    ans.add(sb.toString());
                    return ans;
                }

                int numWords = right - left;
                int numSpaces = maxWidth - sumLen;

                // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
                if (numWords == 1) {
                    StringBuffer sb = new StringBuffer(words[left]);
                    sb.append(blank(numSpaces));
                    ans.add(sb.toString());
                    continue;
                }

                // 当前行不只一个单词
                int avgSpaces = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);
                StringBuffer sb = new StringBuffer();
                sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // 拼接额外加一个空格的单词
                sb.append(blank(avgSpaces));
                sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // 拼接其余单词
                ans.add(sb.toString());
            }
        }

        // blank 返回长度为 n 的由空格组成的字符串
        public String blank(int n) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; ++i) {
                sb.append(' ');
            }
            return sb.toString();
        }

        // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
        public StringBuffer join(String[] words, int left, int right, String sep) {
            StringBuffer sb = new StringBuffer(words[left]);
            for (int i = left + 1; i < right; ++i) {
                sb.append(sep);
                sb.append(words[i]);
            }
            return sb;
        }
    }

    // 输出输入信息
    public void printInput(String[] words,int maxWidth) {
        System.out.println("输入");
        System.out.println("words = [" + String.join(", ", words) + "]");
        System.out.println("maxWidth = " + maxWidth);
    }

    // 输出结果和预期结果
    public void printOutput(List<String> result, List<String> expected) {
        System.out.println("输出");
        for (String line : result) {
            System.out.println(line);
        }
        System.out.println("预期结果");
        for (String line : expected) {
            System.out.println(line);
        }
    }
    // 测试用例1：标准输入
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> expected= Arrays.asList(
                "This    is    an",
                "example  of text",
                "justification.  ");
        printInput(words,maxWidth);
        List<String> result = solution.fullJustify(words, maxWidth);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例2：处理单词只有一个的情况
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        List<String> expected = Arrays.asList(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );

        printInput(words,maxWidth);
        List<String> result = solution.fullJustify(words, maxWidth);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例3：长文本，检查空格分配
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String[] words = {"Science", "is", "what", "we", "understand", "well",
                "enough", "to", "explain", "to", "a", "computer.", "Art", "is",
                "everything", "else", "we", "do"};
        int maxWidth = 20;
        List<String> expected = Arrays.asList(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );

        printInput(words,maxWidth);
        List<String> result = solution.fullJustify(words, maxWidth);
        printOutput(result,expected);
        assertEquals(expected, result);
    }
}
