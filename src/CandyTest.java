import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class CandyTest {

    static class Solution {
        public int candy(int[] ratings) {
            int length=ratings.length;
            int []candyCount=new int[length];
            //如果小于两个人，直接返回应有糖果数
            if(length<2) return length;
            //初始化第一颗糖
            candyCount[0]=1;
            //从左到右发一遍,从第二个人开始
            for(int i=1;i<length;i++){
                //如果比左边的人成绩高，给一颗糖
                if(ratings[i]>ratings[i-1])
                    candyCount[i]=candyCount[i-1]+1;
                //否则只给一颗糖
                else candyCount[i]=1;
            }
            //糖果总数
            int count=candyCount[length-1];
            //从右到左发一遍,从倒数第二个人开始
            for(int i=length-2;i>=0;i--){
                //如果比右边的人成绩高，多一颗糖
                if(ratings[i]>ratings[i+1])
                    candyCount[i]=candyCount[i]>candyCount[i+1]?candyCount[i]:candyCount[i+1]+1;
                //计算糖果总数
                count=count+candyCount[i];
            }
            return count;
        }
    }

    // 测试用例1：ratings = [1, 0, 2]
    @Test
    public void testCase1() {
        Solution solution = new Solution();
        int[] ratings = {1, 0, 2};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 5

        assertEquals(5, result); // 预期结果是 5
    }

    // 测试用例2：ratings = [1, 2, 2]
    @Test
    public void testCase2() {
        Solution solution = new Solution();
        int[] ratings = {1, 2, 2};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 4

        assertEquals(4, result); // 预期结果是 4
    }

    // 测试用例3：ratings = [1, 2, 3, 4, 5]
    @Test
    public void testCase3() {
        Solution solution = new Solution();
        int[] ratings = {1, 2, 3, 4, 5};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 15

        assertEquals(15, result); // 预期结果是 15
    }

    // 测试用例4：ratings = [5, 4, 3, 2, 1]
    @Test
    public void testCase4() {
        Solution solution = new Solution();
        int[] ratings = {5, 4, 3, 2, 1};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 15

        assertEquals(15, result); // 预期结果是 15
    }

    // 测试用例5：ratings = [1, 3, 2, 2, 1]
    @Test
    public void testCase5() {
        Solution solution = new Solution();
        int[] ratings = {1, 3, 2, 2, 1};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 7

        assertEquals(7, result); // 预期结果是 7
    }

    // 测试用例6：ratings = [1, 1, 1, 1]
    @Test
    public void testCase6() {
        Solution solution = new Solution();
        int[] ratings = {1, 1, 1, 1};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 4

        assertEquals(4, result); // 预期结果是 4
    }

    // 测试用例7：ratings = [3, 1, 4, 2, 5]
    @Test
    public void testCase7() {
        Solution solution = new Solution();
        int[] ratings = {3, 1, 4, 2, 5};

        System.out.println("输入");
        System.out.println("ratings = " + Arrays.toString(ratings));

        int result = solution.candy(ratings);

        System.out.println("输出");
        System.out.println(result);  // 9

        assertEquals(8, result); // 预期结果是 9
    }
}
