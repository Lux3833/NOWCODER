package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @title: Test40
 * @Author: Lux_er
 * @Date: 2021/3/20 0020 上午 11:44
 * @Description:
 * 给定一个数组candidates和一个目标数target，找出candidates中
 * 所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Test40 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] arr = utils.inputNums();
        int target = utils.inputNumber();
        List<List<Integer>> list = combinationSum2(arr,target);
        System.out.println(list);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(0,0,candidates,target,list,lists);
        return lists;
    }

    private static void dfs2(int index, int count, int[] candidates, int target, List<Integer> list, List<List<Integer>> lists) {
        if(count == target){
            List<Integer> vaList = new ArrayList<Integer>();
            vaList.addAll(list);
            lists.add(vaList);
        }else{
            for (int i = index; i < candidates.length; i++) {
                if(target >= count+candidates[i]){
                    if(i != index && candidates[i] == candidates[i-1]){
                        continue;
                    }
                    list.add(candidates[i]);
                    dfs2(i+1, count+candidates[i],candidates,target,list, lists);
                    list.remove(list.size()-1);
                }else{
                    break;
                }
            }
        }
    }
}
