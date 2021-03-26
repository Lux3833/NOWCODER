package SimpleAlgorithm.Sort;
/**
 * @title: SelectSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 上午 11:17
 * @Description:
 * 选择排序
 */
public class SelectSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        arr = selectSort(arr);
        utils.showNums(arr);
    }

    private static int[] selectSort(int[] arr) {
        int index = 0;
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[index] > arr[j]){
                    index = j;
                }
            }
            if(index != i){
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
