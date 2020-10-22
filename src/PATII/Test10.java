package PATII;

import java.text.DecimalFormat;
import java.util.*;

/**
 * @author - Lx
 * @date - 2020/10/16 - 11:08
 * @Description: 题目描述
 * 月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需
 * 求量，请你计算可以获得的最大收益是多少。
 * <p>
 * 注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、
 * 72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得
 * 72 + 45/2 = 94.5（亿元）。
 * <p>
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数
 * D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿
 * 元为单位）。数字间以空格分隔。
 * <p>
 * <p>
 * 输出描述:
 * 对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。
 * <p>
 * 输入例子:
 * 3 20
 * 18 15 10
 * 75 72 45
 * <p>
 * 输出例子:
 * 94.50
 */
class MoonCake {
    public int amount;
    public int price;
    public double rate;

    public MoonCake(int amount, int price) {
        this.amount = amount;
        this.price = price;
        this.rate = price * 1.0 / amount;
    }
}

public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        ArrayList<MoonCake> list = new ArrayList<MoonCake>();

        int[] amount = new int[N];
        int[] price = new int[N];
        double[] rate = new double[N];
        int[] priority = new int[N];
        for (int i = 0; i < N; i++) {
            amount[i] = scanner.nextInt();
        }
        for (int j = 0; j < N; j++) {
            price[j] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < N; i++) {
            MoonCake moonCake = new MoonCake(amount[i], price[i]);
            list.add(moonCake);
        }
        Collections.sort(list, new Comparator<MoonCake>() {
            @Override
            public int compare(MoonCake o1, MoonCake o2) {
                if (o1.rate > o2.rate) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        double profit = 0;
        //计算月饼利润
        for (int i = 0; i < N; i++) {
            if (D >= list.get(i).amount) {
                D -= list.get(i).amount;
                profit += list.get(i).price;
            } else {
                profit += list.get(i).rate * D;
                D = 0;
                break;
            }
        }
        DecimalFormat dl = new DecimalFormat(".00");
        System.out.println(dl.format(profit));
    }
}
