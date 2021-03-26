package SimpleAlgorithm.Sort;
/**
 * @title: HeapSort
 * @Author: Lux_er
 * @Date: 2021/3/14 0014 下午 3:15
 * @Description:
 * 堆排序
 */
public class HeapSort {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        heapSort(nums,nums.length);
        utils.showNums(nums);
    }

    private static void heapSort(int[] nums, int length) {
        int i;
        int temp;
        //建堆
        for(i = length/2 - 1;i >= 0;i--){
            heapify(nums,length,i);
        }
        //排序
        for (i = length - 1;i > 0;i--) {
            temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums,i,0);

        }
    }
    //n 数组长度 i 待维护节点的下标
    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int lson = 2 * i + 1;
        int rson = 2 * i + 2;
        int temp;
        if(lson < n && nums[largest] < nums[lson]){
            largest = lson;
        }
        if(rson < n && nums[largest] < nums[rson]){
            largest = rson;
        }
        if(largest != i){
            temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(nums, n, i);
        }
    }
}
