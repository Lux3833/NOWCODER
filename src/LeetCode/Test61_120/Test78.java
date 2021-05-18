package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test78
 * @Author: Lux_er
 * @Date: 2021/5/18 0018 上午 9:37
 * @Description:子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Test78 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        List<List<Integer>> lists = subsets(nums);
        for (int i = 0; i < lists.size(); i++) {
            utils.printListInteger(lists.get(i));
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        return process(lists,list,0,nums);
    }

    private static List<List<Integer>> process(List<List<Integer>> lists, List<Integer> list, int index, int[] nums) {
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            lists.add(temp);
            return lists;
        }
        list.add(nums[index]);
        process(lists,list,index+1,nums );
        list.remove(list.size()-1);
        process(lists,list,index+1,nums);
        return lists;
    }
}
