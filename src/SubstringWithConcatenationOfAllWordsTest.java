import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWordsTest {

    static class Solution {

        // 方法：查找所有满足条件的子串的起始位置
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || words == null || words.length == 0) {
                return result;
            }

            int wordLength = words[0].length();
            //int totalLength = wordLength * words.length;
            Map<String, Integer> wordCount = new HashMap<>();

            // 统计每个单词的出现次数
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            // 遍历字符串，检查每一个可能的起始位置,杜绝不在整数单词开始的可能
            for (int i = 0; i < wordLength; i++) {
                //单词的个数
                int left = i;
                int right = i;
                int count = 0;
                //每个窗口的map
                Map<String, Integer> windowCount = new HashMap<>();
                //匹配窗口并记录
                while (right + wordLength <= s.length()) {
                    // 获取当前单词
                    String word = s.substring(right, right + wordLength);
                    right += wordLength;

                    // 如果当前单词是目标单词之一
                    if (wordCount.containsKey(word)) {
                        //获取当前单词的索引值
                        windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);

                        // 如果窗口中出现了过多的某个单词，则需要调整左指针，左指针向右，去除已有的多余单词
                        while (windowCount.get(word) > wordCount.get(word)) {
                            String leftWord = s.substring(left, left + wordLength);
                            windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                            left += wordLength;
                            count--;
                        }
                        //记录该窗口内的单词数
                        count++;

                        // 如果当前窗口的字数符合要求，则说明找到一个解，记录
                        if (count == words.length) {
                            result.add(left);
                            String leftWord = s.substring(left, left + wordLength);
                            //记录当前索引值
                            windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                            left += wordLength;
                            count--;
                        }
                    } else {
                        // 如果当前单词不在目标单词列表中，则清空窗口
                        // 当前窗口未满足单词数要求，无解，清空窗口,找下一个单词
                        left = right;
                        windowCount.clear();
                        count = 0;
                    }
                }
            }

            return result;
        }
    }

    // 辅助方法，用于打印输入数据
    private void printInput(String s, String[] words) {
        System.out.println("输入");
        System.out.println("s = \"" + s + "\"");
        System.out.println("words = " + Arrays.toString(words));
    }

    // 辅助方法，用于打印输出和预期输出
    private void printOutput(List<Integer> result, List<Integer> expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：输入字符串 "barfoothefoobarman"，words = ["foo", "bar"]，预期结果是 [0, 9]
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> expected = Arrays.asList(0, 9); // 预期输出是 [0, 9]

        printInput(s, words);
        List<Integer> result = solution.findSubstring(s, words);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例2：输入字符串 "wordgoodgoodgoodbestword"，words = ["word", "good", "best", "word"]，预期结果是 []
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> expected = Arrays.asList(); // 预期输出是 []

        printInput(s, words);
        List<Integer> result = solution.findSubstring(s, words);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例3：输入字符串 "barfoofoobarthefoobarman"，words = ["bar", "foo", "the"]，预期结果是 [6, 9, 12]
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> expected = Arrays.asList(6, 9, 12); // 预期输出是 [6, 9, 12]

        printInput(s, words);
        List<Integer> result = solution.findSubstring(s, words);
        printOutput(result, expected);

        assertEquals(expected, result);
    }
}
