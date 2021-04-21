package Other.Zuo.Base.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @title: Graph_Prim
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 3:44
 * @Description:适用范围:无向图
 */
public class Graph_Prim {
    public static Set<Edge> primMST(Graph graph){
        // 解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                new EdgeComparator()
        );
        HashSet<GraphNode> set = new HashSet<>();
        Set<Edge> res = new HashSet<>();// 依次挑选的边在result里
        // for循环考虑到了森林的情况,如果给的图是连通的,就可以省略
        for (GraphNode node : graph.nodes.values()) {
            if(!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    GraphNode toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        res.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return res;
    }

    private static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
