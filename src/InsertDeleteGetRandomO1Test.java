import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.*;

public class InsertDeleteGetRandomO1Test {
    //复杂度为O(1),所以使用哈希
    //只用List是O(n)
    static class RandomizedSet {
        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        //初始化数据
        public RandomizedSet() {
            dict = new HashMap();
            list = new ArrayList();
        }

        //插入数据
        public boolean insert(int val) {
            //已经存在该元素，返回false
            if (dict.containsKey(val)) return false;
            //对应位置插入元素
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        //删除数据
        public boolean remove(int val) {
            //不存在该元素
            if (! dict.containsKey(val)) return false;
            //删除保持O(1),所以要将最后一个元素放在移除元素的位置
            //复制过去
            int lastElement = list.get(list.size() - 1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            //删除最后的元素
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        //随机获得一个数据
        public int getRandom() {
            //随机产生某个范围内的整数
            return list.get(rand.nextInt(list.size()));
        }
        //是否包含对应元素
        public boolean isContained(int val){
            return dict.containsKey(val);
        }
    }

    // 输出输入信息
    public void printInput(String[] operations,Object... inputs) {
        System.out.println("输入");
        System.out.println(Arrays.toString(operations));
        System.out.println(Arrays.deepToString(inputs));
    }

    // 输出结果信息
    public void printOutput(Object[] expectedOutputs,Object... outputs) {
        System.out.println("输出");
        System.out.println(Arrays.deepToString(outputs));
        System.out.println("预期结果");
        System.out.println(Arrays.toString(expectedOutputs));

    }

    @Test
    public void testRandomizedSet() {
        // 模拟操作
        RandomizedSet randomizedSet = new RandomizedSet();

        // 输入操作和对应的输出
        String[] operations = {
                "RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"
        };
        Object[][] inputs = {
                {}, {1}, {2}, {2}, {}, {1}, {2}, {}
        };
        // 打印输入
        printInput(operations, inputs);

        Object[] expectedOutputs = {null,true,false,true,null,true,false,null};
        // 执行操作并验证输出
        List<Object> actualOutputs = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "RandomizedSet":
                    randomizedSet = new RandomizedSet();
                    actualOutputs.add(null);  // Initialization does not return anything
                    break;
                case "insert":
                    boolean insertResult = randomizedSet.insert((Integer) inputs[i][0]);
                    actualOutputs.add(insertResult);
                    break;
                case "remove":
                    boolean removeResult = randomizedSet.remove((Integer) inputs[i][0]);
                    actualOutputs.add(removeResult);
                    break;
                case "getRandom":
                    int randomResult = randomizedSet.getRandom();
                    actualOutputs.add(randomResult);
                    if(randomizedSet.isContained(randomResult)) expectedOutputs[i]=randomResult;
                    break;
            }
        }

        // 打印输出
        printOutput(expectedOutputs, actualOutputs.toArray());

        // 对比预期输出与实际输出
        assertArrayEquals(expectedOutputs, actualOutputs.toArray());
    }
}