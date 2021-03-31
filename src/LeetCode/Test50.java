package LeetCode;

/**
 * @title: Test50
 * @Author: Lux_er
 * @Date: 2021/3/30 0030 上午 10:36
 * @Description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class Test50 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        double x = utils.intputDouble();
        int n = utils.inputNumber();
        double res = myPow(x,n);
        System.out.println(res);
    }

    private static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x,N) : 1.0 / quickMul(x,-N);
    }

    private static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x,N/2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
