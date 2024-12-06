
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class hIndexTest {
    static class Solution {
        public int hIndex(int[] citations) {
            int len=citations.length,hIndex=0;
            //论文数x，若x篇论文的引用量都大于x,就说明hIndex是x
            Arrays.sort(citations);
            for(int i=len-1;i>=0;i--){
                if(citations[i]<len-i) {break;}
                else hIndex++;
            }
            return hIndex;
        }
    }
    // 输出输入信息
    public void printInput(int[] citations) {
        System.out.println("输入\n" + Arrays.toString(citations));
    }

    // 输出结果和预期结果
    public void printOutput(int result, int expected) {
        System.out.println("输出\n" + result + "\n预期结果\n" + expected);
    }

    private final Solution solution = new Solution();

    // 测试用例1
    @Test
    public void testHIndexCase1() {
        int[] citations = {3, 0, 6, 1, 5};
        int expected = 3;
        printInput(citations);
        int result = solution.hIndex(citations);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例2
    @Test
    public void testHIndexCase2() {
        int[] citations = {1, 3, 1};
        int expected = 1;
        printInput(citations);
        int result = solution.hIndex(citations);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例3
    @Test
    public void testHIndexCase3() {
        int[] citations = {0, 0, 0, 0, 0};
        int expected = 0;
        printInput(citations);
        int result = solution.hIndex(citations);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例4
    @Test
    public void testHIndexCase4() {
        int[] citations = {10, 8, 5, 4, 3};
        int expected = 4;
        printInput(citations);
        int result = solution.hIndex(citations);
        printOutput(result, expected);
        assertEquals(expected, result);
    }

    // 测试用例5：边界情况
    @Test
    public void testHIndexCase5() {
        int[] citations = {1};
        int expected = 1;
        printInput(citations);
        int result = solution.hIndex(citations);
        printOutput(result, expected);
        assertEquals(expected, result);
    }
}

