import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class GasStationTest {

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = -1,length=gas.length,gasSum=0,minGas=gas[0];
            for(int i=0;i<length;i++){
                int currentCost=gas[i]-cost[i];
                gasSum+=currentCost;
                //当前油箱若最小.更新起点和最小油量
                if(gasSum<=minGas) {
                    start=i;
                    minGas=gasSum;
                }
            }
            //若没有合适的起点，则返回-1
            start=gasSum<0?-1:(start+length+1)%length;
            return start;
        }
    }
    // 测试用例1：可以从站点 3 开始，完成一圈
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        System.out.println("输入");
        System.out.println("gas = " + Arrays.toString(gas));
        System.out.println("cost = " + Arrays.toString(cost));

        int result = solution.canCompleteCircuit(gas, cost);

        System.out.println("输出");
        System.out.println(result);  // 3

        assertEquals(3, result); // 预期结果是 3
    }

    // 测试用例2：无法完成一圈，从任何站点出发都无法完成
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};

        System.out.println("输入");
        System.out.println("gas = " + Arrays.toString(gas));
        System.out.println("cost = " + Arrays.toString(cost));

        int result = solution.canCompleteCircuit(gas, cost);

        System.out.println("输出");
        System.out.println(result);  // -1

        assertEquals(-1, result); // 预期结果是 -1
    }

    // 测试用例3：只有一个加油站，油量足够
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[] gas = {10};
        int[] cost = {5};

        System.out.println("输入");
        System.out.println("gas = " + Arrays.toString(gas));
        System.out.println("cost = " + Arrays.toString(cost));

        int result = solution.canCompleteCircuit(gas, cost);

        System.out.println("输出");
        System.out.println(result);  // 0

        assertEquals(0, result); // 预期结果是 0
    }

    // 测试用例4：每个加油站的油量和消耗相等
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {1, 2, 3, 4, 5};

        System.out.println("输入");
        System.out.println("gas = " + Arrays.toString(gas));
        System.out.println("cost = " + Arrays.toString(cost));

        int result = solution.canCompleteCircuit(gas, cost);

        System.out.println("输出");
        System.out.println(result);  // 0

        assertEquals(0, result); // 预期结果是 0
    }

    // 测试用例5：油量刚好足够完成一圈
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int[] gas = {3, 2, 4, 5, 6};
        int[] cost = {2, 3, 2, 4, 3};

        System.out.println("输入");
        System.out.println("gas = " + Arrays.toString(gas));
        System.out.println("cost = " + Arrays.toString(cost));

        int result = solution.canCompleteCircuit(gas, cost);

        System.out.println("输出");
        System.out.println(result);  // 2

        assertEquals(2, result); // 预期结果是 2
    }
}
