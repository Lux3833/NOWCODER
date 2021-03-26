package SimpleAlgorithm.Sort;
/**
 * @title: ShellSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 下午 3:50
 * @Description:
 */
public class ShellSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        shellSort(arr,arr.length);
        utils.showNums(arr);
    }

    private static void shellSort(int[] arr,int n) {
        int i , j , inc , key;
        for(inc = n / 2; inc > 0;inc /= 2){
            //每一趟采用插入排序
            for(i = inc;i < n;i++){
                key = arr[i];
                for(j = i;j >= inc && key < arr[j-inc];j -= inc){
                    arr[j] = arr[j - inc];
                }
                arr[j] = key;
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }
}
