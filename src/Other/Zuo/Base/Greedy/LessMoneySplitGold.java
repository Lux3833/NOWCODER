package Other.Zuo.Base.Greedy;

import Other.Zuo.Base.Utils;

import java.util.PriorityQueue;

/**
 * @title: LessMoneySplitGold
 * @Author: Lux_er
 * @Date: 2021/4/22 0022 上午 11:00
 * @Description:切金条问题,可转换为哈夫曼编码问题
 */
public class LessMoneySplitGold {
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while(pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;

    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        int[] arr = utils.inputNums();
        System.out.println(lessMoney(arr));
    }
}
