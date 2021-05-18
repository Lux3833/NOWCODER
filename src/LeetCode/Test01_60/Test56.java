package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @title: Test56
 * @Author: Lux_er
 * @Date: 2021/5/12 0012 下午 3:32
 * @Description:合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 我们用数组 merged 存储最终的答案。
 *
 * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
 *
 * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
 *
 * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
 */
public class Test56 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        int[][] intervals = new int[N][];
        for (int i = 0; i < N; i++) {
            intervals[i] = new int[2];
            intervals[i][0] = utils.inputNumber();
            intervals[i][1] = utils.inputNumber();
        }
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.print("["+res[i][0]+" , "+res[i][1]+"]"+" ");
        }
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
