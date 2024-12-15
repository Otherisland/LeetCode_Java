import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    //用滑动窗口，不满足就缩小窗口
    static class Solution{
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            // 记录结果
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                //如果当前输入字符已经存在，则收缩，直到找到新的适当窗口
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                // 在这里更新最大长度
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

    //麻烦的方法
//    static class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            if(s.isEmpty()) return 0;
//            int longestLen =1;
//            int index=0,subIndex=0,currentLongest=1;
//            while(index+currentLongest<s.length()){
//                currentLongest++;
//                subIndex=index;
//                int j=index+currentLongest-1;
//                //遍历新字符是否与其他字符有相同
//                while(subIndex<j){
//                    //若与其中一个相同
//                    char mainChar=s.charAt(j),subChar=s.charAt(subIndex);
//                    if(mainChar==subChar){
//                        //则新加入的字符跳过
//                        currentLongest--;
//                        longestLen=Math.max(longestLen,currentLongest);
//                        index=subIndex+1;
//                        currentLongest=0;
//                        break;
//                    }
//                    subIndex++;
//                }
//                //更新最大子串长度
//                longestLen=Math.max(longestLen,currentLongest);
//            }
//            return longestLen;
//        }
//    }
    // 辅助方法，用于打印输入数据
    private void printInput(String s) {
        System.out.println("输入");
        System.out.println("s = \"" + s + "\"");
    }

    // 辅助方法，用于打印输出和预期输出
    private void printOutput(int result, int expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：输入字符串 "abcabcbb"，预期结果是 3
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "abcabcbb";
        int expected = 3; // 预期输出是 3，因为最长不重复子串是 "abc"。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例2：输入字符串 "bbbbb"，预期结果是 1
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "bbbbb";
        int expected = 1; // 预期输出是 1，因为最长不重复子串是 "b"。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例3：输入字符串 "pwwkew"，预期结果是 3
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "pwwkew";
        int expected = 3; // 预期输出是 3，因为最长不重复子串是 "wke"。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例4：输入一个空字符串，预期结果是 0
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "";
        int expected = 0; // 预期输出是 0，因为字符串为空，最长子串长度为 0。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例5：输入字符串 "abcde"，预期结果是 5
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String s = "abcde";
        int expected = 5; // 预期输出是 5，因为最长不重复子串是 "abcde"。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

    // 测试用例6：输入字符串 "dvdf"，预期结果是 3
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String s = "dvdf";
        int expected = 3; // 预期输出是 5，因为最长不重复子串是 "vdf"。

        printInput(s);
        int result = solution.lengthOfLongestSubstring(s);
        printOutput(result, expected);

        assertEquals(expected, result);
    }

}
