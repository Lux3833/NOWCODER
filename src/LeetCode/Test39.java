package LeetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test39
 * @Author: Lux_er
 * @Date: 2021/3/19 0019 下午 3:18
 * @Description:
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中
 * 所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Test39 {

    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        int target = utils.inputNumber();
        List<List<Integer>> list = combinationSum(arr,target);
        System.out.println(list);
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(0,0,arr,target,list,lists);
        return lists;
    }

    public static void dfs(int index, int count, int[] arr, int target,List<Integer> list,List<List<Integer>> lists) {
        if(count == target){
            List<Integer> vaList = new ArrayList<Integer>();
            vaList.addAll(list);
            lists.add(vaList);
        }else{
            for (int i = index; i < arr.length; i++) {
                if(count + arr[i] <= target){
                    list.add(arr[i]);
                    dfs(i,count+arr[i],arr,target,list,lists);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
