package SimpleAlgorithm.Sort;
/**
 * @title: BubbleSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 上午 10:10
 * @Description:
 * 冒泡排序改进
 */
public class BubbleSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        arr = bubbleSort(arr);
        utils.showNums(arr);
    }

    private static int[] bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            boolean hasOrdered = true;
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    hasOrdered = false;
                }
            }
            if(hasOrdered){
                break;
            }
        }
        return arr;
    }
}
