package LeetCode.Test61_120;

import LeetCode.Utils;

import java.util.TreeSet;

/**
 * @title: Test73
 * @Author: Lux_er
 * @Date: 2021/5/16 0016 上午 10:03
 * @Description:矩阵置零
 * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 进阶：
 * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * 示例：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class Test73 {
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
        setZeroes(matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // 空间复杂度O(m*n)
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isZero = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isZero[i][j] == true)
                    continue;
                if(matrix[i][j] == 0){
                    isZero[i][j] = true;
                    for (int k = 0; k < n; k++) {
                        if(matrix[i][k] != 0){
                            matrix[i][k] = 0;
                            isZero[i][k] = true;
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        if(matrix[k][j] != 0){
                            matrix[k][j] = 0;
                            isZero[k][j] = true;
                        }
                    }
                }
            }
        }
    }
    // 空间复杂度O(m+n)
    public static void setZeroes2(int[][] matrix) {
        // 设置行数组，判断该行是否要置为0
        // 设置列数组，判断该列是否要置为0
        boolean hang[]=new boolean[matrix.length];
        boolean lie[]=new boolean[matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0) {
                    hang[i] = true;
                    lie[j] = true;
                }
            }
        }
        for(int i=0;i<hang.length;i++)
        {
            if(hang[i])
            {
                for(int j=0;j<lie.length;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<lie.length;j++)
        {
            if(lie[j])
            {
                for(int i=0;i<hang.length;i++)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
    // 空间复杂度O(1)
    // 先遍历矩阵每个值，找到不存在的值，记为num
    // 行遍历矩阵，遇到0，则将该行0以外的值全设置为num
    // 接着列遍历矩阵，遇到0，将该列的所有值设为0，如果遇到num，也设置为0
    public void setZeroes3(int[][] matrix) {
        boolean jud=false;
        int num=1;
        //找到一个合适的数字用于临时替换
        for(int q=1;q<matrix.length*matrix[0].length+2;q++)
        {
            jud=false;
            outer:
            for (int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[i].length;j++)
                {
                    if(matrix[i][j]==q) {
                        jud=true;
                        break outer;
                    }
                }
            }
            if(!jud)
            {
                num=q;break;
            }
        }
        //遍历行
        for (int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    for(int q=0;q<matrix[0].length;q++)
                    {
                        if(matrix[i][q]!=0)
                            matrix[i][q]=num;
                    }
                    break;
                }
            }
        }
        for(int j=0;j<matrix[0].length;j++)//列
        {
            for (int i=0;i<matrix.length;i++)
            {
                if(matrix[i][j]==0)
                {
                    for(int q=0;q<matrix.length;q++)
                    {
                        matrix[q][j]=0;
                    }
                    break;
                }
                if(matrix[i][j]==num)
                    matrix[i][j]=0;
            }
        }
    }
}
