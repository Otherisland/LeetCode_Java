import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockIITest {

    // 解决问题的算法
    static class Solution {
        public int maxProfit(int[] prices) {
            int len=prices.length;
            if(len<2) return 0;
            int maxProfit = 0;
            //把两个间隔为正的加起来就行
            for(int i=1;i<len;i++){
                int currentProfit=prices[i]-prices[i-1];
                //如果第二天价格上涨,最大利润更新，相加
                maxProfit += Math.max(currentProfit,0);
            }
            return maxProfit;
        }
    }

    private final Solution solution = new Solution();

    // 用于统一打印输入的格式
    public void printInput(int[] prices) {
        System.out.println("输入");
        System.out.println("prices=");
        System.out.println(Arrays.toString(prices));

    }
    // 用于统一打印输出的格式
    public void printOutput(int val, int expected) {
        System.out.println("输出");
        System.out.println(val);
        System.out.println("预期结果");
        System.out.println(expected);
    }

    // 测试用例1：正常情况下有多次买卖的利润
    @Test
    public void testMaxProfitCase1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;  // 4 + 3 = 7
        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
    }

    // 测试用例2：价格持续上涨
    @Test
    public void testMaxProfitCase2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;  // 买入1卖出5，最大利润 = 5 - 1 = 4
        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result, expected);
    }

    // 测试用例3：价格持续下降，无法获利
    @Test
    public void testMaxProfitCase3() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;  // 无法获利
        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result, expected);
    }

    // 测试用例4：价格交替波动，能多次买卖获利
    @Test
    public void testMaxProfitCase4() {
        int[] prices = {1, 7, 3, 4, 9, 2};
        int expected = 12;  // 6 + 1 + 8 = 12
        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result, expected);
    }

    // 测试用例5：只有一个价格
    @Test
    public void testMaxProfitCase5() {
        int[] prices = {5};
        int expected = 0;  // 只有一个价格，无法买卖
        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result, expected);
    }
}
