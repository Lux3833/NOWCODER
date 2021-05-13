package LeetCode;

/**
 * @title: Test59
 * @Author: Lux_er
 * @Date: 2021/5/13 0013 下午 3:26
 * @Description:螺旋矩阵
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class Test59 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[][] arr = new int[n][n];
        arr = generateMatrix(n);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int val[][]=new int [n][n];
        int value=1;
        // index是圈数
        for(int index=0;index<n/2;index++)
        {
            for(int i=index;i<n-index-1;i++)
            {
                val[index][i]=value++;
            }
            for(int i=index;i<n-index-1;i++)
            {
                val[i][n-index-1]=value++;
            }
            for(int i=n-index-1;i>index;i--)
            {
                val[n-index-1][i]=value++;
            }
            for(int i=n-index-1;i>index;i--)
            {
                val[i][index]=value++;
            }
        }
        if(n%2==1)
            val[n/2][n/2]=value;
        return val;
    }

}
