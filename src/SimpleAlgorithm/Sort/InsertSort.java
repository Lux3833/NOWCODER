package SimpleAlgorithm.Sort;
/**
 * @title: InsertSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 下午 3:37
 * @Description:
 * 插入排序
 */
public class InsertSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        insertSort(arr);
        utils.showNums(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int t = arr[i];//需要缓存arr[i]的值，否则会出错
            while(j >= 0 && t < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = t; //不要忘记，很重要
        }
    }
}
