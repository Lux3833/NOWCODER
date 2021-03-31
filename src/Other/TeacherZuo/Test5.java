package Other.TeacherZuo;
/**
 * @title: Test5
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 4:53
 * @Description:
 * 给定两个长度都为N的数组weights和values,
 * weights[i]和values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag,表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 */
public class Test5 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] weights = utils.inputNums();
        int[] values = utils.inputNums();
        int bag = utils.inputNumber();
        int maxValue = process(weights, values, 0, 0, bag);
        System.out.println(maxValue);
    }

    public static int process(int[] weights,int[] values,int index,int alreadyW,int bag){
        if(alreadyW > bag){
            return -1;//没有可行方案
        }
        //重量没超
        if(index == weights.length){
            return 0;
        }
        //没有加index位置上的重物，后续能产生的价值
        int p1 = process(weights,values,index+1,alreadyW,bag);
        //加了当前重物，后续能产生的价值
        int p2next = process(weights, values, index+1, alreadyW+weights[index],bag);
        int p2 = -1;
        if(p2next != -1){
            p2 = values[index] + p2next;
        }
        return Math.max(p1,p2);
    }
}
