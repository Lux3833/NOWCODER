package LeetCode;

/**
 * @title: Test55
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 8:52
 * @Description:跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Test55 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        boolean res = cap(arr,0);
        System.out.println(res);
    }

    private static boolean cap(int[] arr, int i) {
        if(arr == null || arr.length == 0 ){
            return false;
        }
        if(arr[i]+i >= arr.length-1){
            return true;
        }
        if(arr[arr[i]+i] == 0){
            return false;
        }
        int res = Integer.MIN_VALUE;
        int index = i;
        for (int j = i; j < arr[i]+i; j++) {
            if(res <= arr[j]+j){
                res = arr[j]+j;
                index = j;
            }
        }
        if(arr[index]+index >= arr.length-1){
            return true;
        }else{
            cap(arr, index);
        }
        return false;
    }
}
