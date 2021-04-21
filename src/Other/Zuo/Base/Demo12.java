package Other.Zuo.Base;

/**
 * @title: Demo12
 * @Author: Lux_er
 * @Date: 2021/4/20 0020 下午 4:22
 * @Description:
 * N次对折一长纸条,打印从上到下,折痕的状态
 */
public class Demo12 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        printAllFolds(N);
    }

    private static void printAllFolds(int N) {
        printProcess(1,N,true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if(i > N){
            return;
        }
        printProcess(i+1,N,true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i+1, N, false);
    }
}
