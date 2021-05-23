package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test57
 * @Author: Lux_er
 * @Date: 2021/5/13 0013 上午 11:04
 * @Description:插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Test57 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        int[][] intervals = new int[N][];
        for (int i = 0; i < N; i++) {
            intervals[i] = new int[2];
            intervals[i][0] = utils.inputNumber();
            intervals[i][1] = utils.inputNumber();
        }
        int[] newInterval = new int[2];
        newInterval[0] = utils.inputNumber();
        newInterval[1] = utils.inputNumber();
        int[][] res = insert(intervals,newInterval);
        for (int i = 0; i < res.length; i++) {
            System.out.print("["+res[i][0]+" , "+res[i][1]+"]"+" ");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
