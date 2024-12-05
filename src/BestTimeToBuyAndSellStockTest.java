import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class BestTimeToBuyAndSellStockTest {
    class Solution {
        public int maxProfit(int[] prices) {
            //判断存在两个价格
            int len=prices.length;
            if(len<2) return 0;
            //最大利润取最小价格和最大利润，因为卖出买入不用输出，所以比较直接对比
            //如果需要输出具体的卖出买入，就需要排序或者取最大最小，贪心算法
            int maxProfit=0,minPrice=prices[0];
            for(int price:prices){
                //找到最小成本，更新
                minPrice=Math.min(minPrice,price);
                int currentProfit=price-minPrice;
                //如果有最大利润，更新
                maxProfit=Math.max(maxProfit,currentProfit);
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

    // 测试用例1：正常情况下有利润
    @Test
    public void testMaxProfitCase1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;

        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result,expected);
    }

    // 测试用例2：没有利润
    @Test
    public void testMaxProfitCase2() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;

        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result,expected);
    }

    // 测试用例3：只含有一个价格
    @Test
    public void testMaxProfitCase3() {
        int[] prices = {10};
        int expected = 0;

        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result,expected);
    }

    // 测试用例4：价格完全递增
    @Test
    public void testMaxProfitCase4() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;

        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result,expected);
    }

    // 测试用例5：价格完全递减
    @Test
    public void testMaxProfitCase5() {
        int[] prices = {5, 4, 3, 2, 1};
        int expected = 0;

        printInput(prices);
        int result = solution.maxProfit(prices);
        assertEquals(expected, result);
        printOutput(result,expected);
    }
}
