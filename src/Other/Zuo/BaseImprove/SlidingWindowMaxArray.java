package Other.Zuo.BaseImprove;

import java.util.LinkedList;

/**
 * @title: SlidingWindowMaxArray
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 7:24
 * @Description:
 * 滑动窗口,主要用双端队列来实现,队列保持严格单调性,
 * 头部维持窗口未过期值
 */
public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr,int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        // i是数组下标,也是双端队列存储的数据
        for (int i = 0; i < arr.length; i++) {
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
