package Other.Zuo.Base;

import java.util.PriorityQueue;

/**
 * @title: Demo6
 * @Author: Lux_er
 * @Date: 2021/4/15 0015 下午 9:51
 * @Description:堆排序扩展
 * 已知一个几乎有序的数组,几乎有序是指,如果把数组排好顺序,每个元素移动的距离
 * 可以不超过k,并且k相对于数组来说比较小.请选择一个合适的排序算法
 * 针对这个数据进行排序
 * ##需要利用小根堆,而优先队列默认就是小根堆,其底层是堆结构##
 */
public class Demo6 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int k = utils.inputNumber();;
        int[] arr = utils.inputNums();
        sortedArrDistanceLessK(arr,k);
        for (int i : arr) {
            System.out.println(i+" ");
        }
    }

    private static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(;index <= Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(;index < arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
