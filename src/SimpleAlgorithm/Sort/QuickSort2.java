package SimpleAlgorithm.Sort;
/**
 * @title: QuickSort2
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 上午 11:12
 * @Description:
 * 更好理解的快排
 */
public class QuickSort2 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        arr = quickSort(arr,0,arr.length-1);
        utils.showNums(arr);
    }

    private static int[] quickSort(int[] src,int begin,int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
        return src;
    }
}
