package Other.Zuo.Base.Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @title: IPO
 * @Author: Lux_er
 * @Date: 2021/4/22 0022 上午 11:20
 * @Description:
 * 输入:正数数组costs 表示项目的花费
 *      正数数组profits,表示项目的利润
 *      正数k,表示最多串行可做的项目
 *      正数m,表示初始资金
 * 输出:最后获得的最大钱数w
 */
public class IPO {
    public static class Node{
        // 项目启动资金P以及带来的利润c
        public int p;
        public int c;

        public Node(int p,int c){
            this.p = p;
            this.c = c;
        }
    }
    // 按照最小花费来从小到大排序
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    // 按照最大利润来从大到小排序
    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    // k 最多做多少项目,w 初始资金
    public static int findMaximizedCaptial(int k,int w,int[] Profits,int[] Capital){
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 所有项目扔到被锁池中,花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i],Capital[i]));

        }
        for (int i = 0; i < k; i++) {
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            // 如果此时没有其他项目可做,提前返回
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
