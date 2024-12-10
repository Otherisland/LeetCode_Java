import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {

    static class Solution {
        public String reverseWords(String s) {
            //去掉s前后的空格
            //有空格会影响分割结果
            s=s.trim();
            //\s代表正则表达式中的一个空白字符（可能是空格、制表符、其他空白）
            //\\代表转义字符
            //+代表，+前面的字符至少出现过一次
            String[] words = s.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for(int i = words.length - 1; i >= 0; i--){
                sb.append(words[i]);
                if(i != 0)
                    sb.append(" ");
            }
            return sb.toString();
        }
    }

    // 输出输入信息
    public void printInput(String s) {
        System.out.println("输入");
        System.out.println("s=");
        System.out.println(s);
    }

    // 输出结果和预期结果
    public void printOutput(String result, String expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：标准输入
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "the sky is blue";
        String expected="blue is sky the";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例2：输入有前后空格
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "  hello world  ";
        String expected="world hello";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例3：输入有多个空格
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "a good   example";
        String expected="example good a";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例4：只有一个单词
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "hello";
        String expected="hello";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例5：输入为空字符串
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String s = "";
        String expected="";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }

    // 测试用例6：输入字符串由多个空格组成
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String s = "    ";
        String expected="";

        printInput(s);
        String result = solution.reverseWords(s);
        printOutput(result,expected);
        assertEquals(expected, result);
    }
}
