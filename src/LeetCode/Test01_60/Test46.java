package LeetCode.Test01_60;
import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @title: Test46
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 2:13
 * @Description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Test46 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        List<List<Integer>> lists = new ArrayList<>();
        lists = permute(arr);
        System.out.println(lists);
    }

    private static List<List<Integer>> permute(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        List<List<Integer>> lists = new ArrayList<>();
        fullpermutation(arr.length,lists,list,0);
        return lists;
    }

    private static void fullpermutation(int len,List<List<Integer>> lists, List<Integer> list, int index) {
        if(index == len){
            lists.add(new ArrayList(list));
        }else{
            for (int i = index; i < len; i++) {
                Collections.swap(list,index,i);
                fullpermutation(len,lists, list, index+1);
                Collections.swap(list,index, i);
            }
        }
    }
}
