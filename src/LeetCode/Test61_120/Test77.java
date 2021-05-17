package LeetCode.Test61_120;

import LeetCode.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test77
 * @Author: Lux_er
 * @Date: 2021/5/17 0017 上午 11:18
 * @Description:组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例：
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Test77 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int k = utils.inputNumber();
        List<List<Integer>> lists = combine(n,k);
        for (int i = 0; i < lists.size(); i++) {
            utils.printListInteger(lists.get(i));
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> valueList=new ArrayList<List<Integer>>();
        int num[]=new int[n];
        //避免ab和ba的情况，对于重复的情况，可以借助一个下标只遍历下标后面的数字，就可以避免重复。
        boolean jud[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            num[i]=i+1;
        }
        dfs(num,-1,k,valueList,jud,n);
        return valueList;
    }

    private static void dfs(int[] num,int index, int count,List<List<Integer>> valueList,boolean jud[],int n) {
        if (count == 0) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (jud[i]) {
                    list.add(i + 1);
                }
            }
            valueList.add(list);
        } else {
            for (int i = index + 1; i < n; i++) {
                jud[i] = true;
                dfs(num, i, count - 1, valueList, jud, n);
                jud[i] = false;
            }
        }
    }
}
