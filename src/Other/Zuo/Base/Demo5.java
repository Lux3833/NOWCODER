package Other.Zuo.Base;

import SimpleAlgorithm.Sort.HeapSort;

/**
 * @title: Demo5
 * @Author: Lux_er
 * @Date: 2021/4/14 0014 下午 6:58
 * @Description:堆排序
 */
public class Demo5 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+" ");
        }
    }

    private static void heapSort(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        for (int i = 0; i < nums.length; i++) {//O(N)
            heapInsert(nums,i);//O(logN)
        }
        int heapSize = nums.length;
        new Utils().swap(nums,0,--heapSize);
        while(heapSize > 0){//O(N)
            heapify(nums,0,heapSize);//O(logN)
            new Utils().swap(nums,0,--heapSize);////O(1)
        }
    }

    private static void heapInsert(int[] nums, int index) {
        while(nums[index] > nums[(index - 1)/2]){
            new Utils().swap(nums, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    private static void heapify(int[] nums, int index, int heapSize) {
        //左孩子下标
        int left = index * 2 + 1;
        while(left < heapSize){//还有孩子时
            int largest = left+1 < heapSize && nums[left+1] > nums[left]
                    ? left+1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            }
            new Utils().swap(nums, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

}
