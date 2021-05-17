package LeetCode.Test61_120;

import LeetCode.Utils;

/**
 * @title: Test75
 * @Author: Lux_er
 * @Date: 2021/5/17 0017 上午 10:17
 * @Description:颜色分类
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 示例：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class Test75 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        sortColors(nums);
        utils.printIntNum(nums);
    }

    private static void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<right+1;i++)
        {
            if(nums[i]==0)
            {
                int team=nums[left];
                nums[left++]=0;
                nums[i]=team;
            }
            else if(nums[i]==2)
            {
                int team=nums[right];
                nums[right--]=2;
                nums[i]=team;
                i--;
            }
        }
    }
}
