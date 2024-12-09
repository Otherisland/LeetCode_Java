import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class IntegerToRomanTest {

    static class Solution {
        //1000,500,100,50,10,5,1
        //M,D,C,L,X,V,I
        //900,400,90,40,9,4
        //CM,CD,XC,XL,IX,IV
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            //需要返回的字符串
            StringBuffer roman = new StringBuffer();
            //贪心算法，每个数值对比，取最大的值
            for (int i = 0; i < values.length; ++i) {
                //对比的数值和对应的字符
                int value = values[i];
                String symbol = symbols[i];
                //若num大于当前对比的数值，则增加这个值的字符，倍数增加
                while (num >= value) {
                    //增加后num减小
                    num -= value;
                    roman.append(symbol);
                }
                //直到num为0，原num表达完毕
                if (num == 0) break;
            }
            return roman.toString();
        }
    }

    // 输出输入信息
    public void printInput(int num) {
        System.out.println("输入");
        System.out.println("num = " + num);
    }

    // 输出结果和预期结果
    public void printOutput(String result, String expected) {
        System.out.println("输出");
        System.out.println(result);  // 3
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：整数 3749 -> 罗马数字 "MMMDCCXLIX"
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int num = 3749;
        String expected="MMMDCCXLIX";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }

    // 测试用例2：整数 58 -> 罗马数字 "LVIII"
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int num = 58;
        String expected="LVIII";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }

    // 测试用例3：整数 1994 -> 罗马数字 "MCMXCIV"
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int num = 1994;
        String expected="MCMXCIV";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }

    // 测试用例4：整数 9 -> 罗马数字 "IX"
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int num = 9;
        String expected="IX";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }

    // 测试用例5：整数 1 -> 罗马数字 "I"
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        int num = 1;
        String expected="I";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }

    // 测试用例6：整数 4000 -> 罗马数字 "MMMM"
    @Test
    public void testCase7() {
        Solution solution = new Solution();
        int num = 4000;
        String expected="MMMM";

        printInput(num);
        String result = solution.intToRoman(num);
        printOutput(expected, result);
        assertEquals(expected, result);
    }
}
