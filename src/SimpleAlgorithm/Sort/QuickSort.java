package SimpleAlgorithm.Sort;
/**
 * @title: QuickSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 上午 10:19
 * @Description:
 * 快速排序
 */
public class QuickSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        arr = quickSort(arr,0,arr.length-1);
        utils.showNums(arr);
    }

    private static int[] quickSort(int[] arr,int left,int right) {
        int ltemp = left;
        int rtemp = right;
        int mid = (right + left) / 2;
        int temp = 0;
        while(ltemp < rtemp){
            while(arr[ltemp] < arr[mid]){
                ltemp++;
            }
            while(arr[rtemp] > arr[mid]){
                rtemp--;
            }
            if(ltemp <= rtemp){
                temp = arr[ltemp];
                arr[ltemp] = arr[rtemp];
                arr[rtemp] = temp;
                rtemp--;
                ltemp++;
            }
            if (ltemp == rtemp) {
                ltemp++;
            }
        }
        if(left < rtemp){
            quickSort(arr, left, ltemp-1);
        }
        if(ltemp < right){
            quickSort(arr, rtemp+1, right);
        }
        return arr;
    }
}
