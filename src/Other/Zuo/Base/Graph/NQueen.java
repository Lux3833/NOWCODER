package Other.Zuo.Base.Graph;

import Other.Zuo.Base.Utils;

/**
 * @title: NQueen
 * @Author: Lux_er
 * @Date: 2021/4/22 0022 上午 11:39
 * @Description:
 */
public class NQueen {
    public static int num1(int n){
        if(n < 1){
            return 0;
        }
        // record[i] -> i行的皇后,放在了第几列
        int[] record = new int[n];
        return process(0,record,n);
    }

    private static int process(int i, int[] record, int n) {
        if(i == n){
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(record,i,j)){
                record[i] = j;
                res += process(i+1, record, n);
            }
        }
        return res;
    }
    // 返回第i行皇后,放在了j列,是否有效
    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if(j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        System.out.println(num1(N));
    }
}
