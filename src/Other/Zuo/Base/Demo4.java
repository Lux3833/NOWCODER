package Other.Zuo.Base;

/**
 * @title: Demo4
 * @Author: Lux_er
 * @Date: 2021/4/2 0002 下午 9:35
 * @Description:
 * 快排3.0
 */
public class Demo4 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static void quickSort(int[] arr,int L,int R) {
        if (L < R) {
            swap(arr,L+(int)(Math.random() * (R - L + 1)),R);
            int[] p = partition(arr,L,R);
            quickSort(arr, L, p[0]-1);// <区
            quickSort(arr, p[1]+1,R);// >区
        }
    }
    //返回等于区域（左边界，右边界），返回一个长度为2的数组
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;// <区右边界
        int more = R;// >区左边界
        while(L < more){// L表示当前数的位置
            if(arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
