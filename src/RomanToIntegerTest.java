import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerTest {

    static class Solution {
        Map<Character,Integer> valuesMap=new HashMap<Character,Integer>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};
        public int romanToInt(String s) {
            int num = 0,length=s.length();
            for(int i=0;i<length;i++){
                //通过当前字符获得对应数值
                int value=valuesMap.get(s.charAt(i));
                //如果当前值小于后一个值,减去
                if(i<length-1&&value<valuesMap.get(s.charAt(i+1)))
                    num=num-value;
                //否则相加
                else num=num+value;
            }
            return num;
        }
    }
    // 输出输入信息
    public void printInput(String roman) {
        System.out.println("输入");
        System.out.println("roman = " + roman);
    }

    // 输出结果和预期结果
    public void printOutput(int result, int expected) {
        System.out.println("输出");
        System.out.println(result);  // 3
        System.out.println("预期结果");
        System.out.println(expected);
    }
    // 测试用例1：Roman numeral "III" -> 3
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String roman = "III";
        int expected=3;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }

    // 测试用例2：Roman numeral "IV" -> 4
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String roman = "IV";
        int expected=4;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }

    // 测试用例3：Roman numeral "IX" -> 9
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String roman = "IX";
        int expected=9;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }

    // 测试用例4：Roman numeral "LVIII" -> 58
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String roman = "LVIII";
        int expected=58;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }

    // 测试用例5：Roman numeral "MCMXCIV" -> 1994
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String roman = "MCMXCIV";
        int expected=1994;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }

    // 测试用例6：Roman numeral "MMXXI" -> 2021
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        String roman = "MMXXI";
        int expected=2021;

        printInput(roman);
        int result = solution.romanToInt(roman);
        printOutput(result, expected);
        assertEquals(expected, result); // 预期结果是 3
    }
}
