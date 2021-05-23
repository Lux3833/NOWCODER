package LeetCode.Test01_60;
import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test47
 * @Author: Lux_er
 * @Date: 2021/3/22 0022 上午 9:29
 * @Description:
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 */
public class Test47 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        List<List<Integer>> lists = new ArrayList<>();
        lists = permute2(arr);
        System.out.println(lists);
    }

    private static List<List<Integer>> permute2(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        List<List<Integer>> lists = new ArrayList<>();
        permutetation(lists,arr.length,list,0);
        return lists;
    }

    private static void permutetation(List<List<Integer>> lists,int len, List<Integer> list, int index) {
        if(index == len){
            lists.add(new ArrayList<Integer>(list));
        }else{
            ArrayList<Integer> visit = new ArrayList<>();
            for (int i = index; i < len; i++) {
                if(!visit.contains(list.get(i))){
                    visit.add(list.get(i));
                    swap(list,i,index);
                    permutetation(lists,len, list, index+1);
                    swap(list,i,index);
                }
            }
        }
    }
    private static void swap(List<Integer> list,int i,int j){
        int temp = 0;
        temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
