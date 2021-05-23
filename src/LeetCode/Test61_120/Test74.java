package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

import java.util.Arrays;

/**
 * @title: Test74
 * @Author: Lux_er
 * @Date: 2021/5/17 0017 上午 9:52
 * @Description:搜索二维矩阵
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例:
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class Test74 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int m = utils.inputNumber();
        int n = utils.inputNumber();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = utils.inputNumber();
            }
        }
        int target = utils.inputNumber();
        System.out.println(searchMatrix(matrix,target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int col = -1;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m-1; i++) {
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                col = i;
                break;
            }
        }
        if(matrix[m-1][0] <= target && matrix[m-1][n-1] >= target){
            col = m-1;
        }
        if(col == -1)
            return false;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           arr[i] = matrix[col][i];
        }
        return Arrays.binarySearch(arr, target) >= 0 ? true : false;
    }
}
