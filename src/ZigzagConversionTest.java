import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ZigzagConversionTest {

    static class Solution {
        public String convert(String s, int numRows) {
            if(numRows<2) return s;
            //设置numRows行的String List，从上到下填充，到头返回
            List<StringBuilder> rows=new ArrayList<>();
            //判断是否到头
            int flag=-1;
            //初始化rows
            for(int i = 0; i < numRows; i++)
                rows.add(new StringBuilder());
                //若新的一行出现了，初始化
            int i=0;flag=-1;
            for(char c:s.toCharArray()){
                //填充字符
                rows.get(i).append(c);
                //到头转向
                if(i==0||i==numRows-1) flag=-flag;
                //向上或者向上填充数组，通过flag控制上下
                i+=flag;
            }
            //结果字符串整合
            StringBuilder res=new StringBuilder();
            for(StringBuilder sb:rows) res.append(sb);
            return res.toString();
        }
    }
    // 输出输入信息
    public void printInput(String s,int numRows) {
        System.out.println("输入");
        System.out.println("s=");
        System.out.println(s);
        System.out.println("numRows=");
        System.out.println(numRows);
    }

    // 输出结果和预期结果
    public void printOutput(String result, String expected) {
        System.out.println("输出");
        System.out.println(result);
        System.out.println("预期结果");
        System.out.println(expected);
    }
    // 测试用例1：numRows = 3
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected="PAHNAPLSIIGYIR";

        printInput(s,numRows);
        String result = solution.convert(s, numRows);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例2：numRows = 4
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected="PINALSIGYAHRPI";

        printInput(s,numRows);
        String result = solution.convert(s, numRows);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例3：numRows = 1，特殊情况，输出与输入相同
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String s = "A";
        int numRows = 1;
        String expected="A";

        printInput(s,numRows);
        String result = solution.convert(s, numRows);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例4：numRows = 5
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        String s = "ABCDEFGHIJKLM";
        int numRows = 5;
        String expected="AIBHJCGKDFLEM";

        printInput(s,numRows);
        String result = solution.convert(s, numRows);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：numRows 大于字符串长度
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        String s = "ABCDE";
        int numRows = 10;
        String expected="ABCDE";

        printInput(s,numRows);
        String result = solution.convert(s, numRows);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}
