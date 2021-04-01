package Other.Zuo.Base;

/**
 * @title: Demo3
 * @Author: Lux_er
 * @Date: 2021/4/1 0001 上午 9:56
 * @Description:
 * 小和问题
 * 在一个数组中，每一个数左边比当前小的数累加起来，称为这个数组的小和
 * 求一个数组的小和,要求O(N*logN)
 */
public class Demo3 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int res = smallSum(nums);
        System.out.println(res);
    }

    private static int smallSum(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        return process(nums,0,nums.length-1);
    }

    private static int process(int[] nums, int l, int r) {
        if(l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process( nums,l,mid)+process(nums,mid+1,r)+merge(nums,l,mid,r);
    }

    private static int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while(p1 <= mid && p2 <= r){
            res += nums[p1] < nums[p2] ? (r - p2 + 1) * nums[p1] : 0;
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid){
            help[i++] = nums[p1++];
        }
        while(p2 <= r){
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l+j] = help[j];
        }
        return res;
    }
}
