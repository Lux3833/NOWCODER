package SimpleAlgorithm.Sort;
/**
 * @title: MergeSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 下午 4:22
 * @Description:
 * 归并排序
 */
public class MergeSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        int[] res = new int[arr.length];
        mergeSort(arr,res,0,arr.length-1);
        utils.showNums(arr);
    }

    private static void mergeSort(int[] arr, int[] res,int start,int end) {
        if(start >= end){
            return;
        }
        int len = end - start,mid = len / 2 + start;
        int start1 = start,end1 = mid;
        int start2 = mid + 1,end2 = end;
        mergeSort(arr, res, start1, end1);
        mergeSort(arr, res, start2, end2);
        int k = start;
        while(start1 <= end1 && start2 <= end2){
            res[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while(start1 <= end1){
            res[k++] = arr[start1++];
        }
        while(start2 <= end2){
            res[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = res[k];
        }
    }
}
