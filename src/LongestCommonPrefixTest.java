import org.junit.Test;
import static org.junit.Assert.*;

public class LongestCommonPrefixTest {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            //默认第一个字符串是prefix
            String prefix = strs[0];
            //记录第几个index是结尾
            int index=0;
            for (int i = 1; i < strs.length; i++) {
                index=0;
                //遍历应该小于当前字符长度
                int charLen=strs[i].length(),preLen=prefix.length();
                //strs[i]前几个字母与prefix前几个字母相同时，相加
                while(index<Math.min(charLen,preLen)&&
                        prefix.charAt(index)==strs[i].charAt(index))
                    index++;
                //去除多余的前缀
                prefix = prefix.substring(0,index);
                if(index==0) break;
                //去除多余的前缀
            }
            return prefix;
        }
    }
    // 输出输入信息
    public void printInput(String[] s) {
        System.out.println("输入");
        System.out.println("s=");
        System.out.println("strs = " + String.join(",", s));
    }

    // 输出结果和预期结果
    public void printOutput(String result, String expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }
    // 测试用例1：有公共前缀
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};

        System.out.println("输入");
        System.out.println("strs = " + String.join(",", strs));

        String result = solution.longestCommonPrefix(strs);

        System.out.println("输出");
        System.out.println(result);  // "fl"

        assertEquals("fl", result); // 预期结果是 "fl"
    }

    // 测试用例2：没有公共前缀
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String[] strs = {"dog", "racecar", "car"};
        String expected="";

        printInput(strs);
        String result = solution.longestCommonPrefix(strs);
        printOutput(result, strs[0]);
        assertEquals(expected, result); // 预期结果是 ""
    }

    // 测试用例3：只有一个单词
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String[] strs = {"apple"};
        String expected="apple";

        printInput(strs);
        String result = solution.longestCommonPrefix(strs);
        printOutput(result, strs[0]);
        assertEquals(expected, result); // 预期结果是 ""
    }

    // 测试用例4：所有单词都相同
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String[] strs = {"test", "test", "test"};
        String expected="test";

        printInput(strs);
        String result = solution.longestCommonPrefix(strs);
        printOutput(result, strs[0]);
        assertEquals(expected, result); // 预期结果是 ""
    }

    // 测试用例5：字符串中含有空字符串
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String[] strs = {"", "b", "c"};
        String expected="";

        printInput(strs);
        String result = solution.longestCommonPrefix(strs);
        printOutput(result, strs[0]);
        assertEquals(expected, result); // 预期结果是 ""
    }

    // 测试用例6：数组只有一个字符串且为空
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String[] strs = {""};
        String expected="";

        printInput(strs);
        String result = solution.longestCommonPrefix(strs);
        printOutput(result, strs[0]);
        assertEquals(expected, result); // 预期结果是 ""
    }
}
