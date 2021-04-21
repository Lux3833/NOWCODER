package Other.Zuo.Base.Graph;

import javax.xml.soap.Node;
import java.util.*;

/**
 * @title: Graph_TopologySort
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 1:58
 * @Description:
 */
public class Graph_TopologySort {
    public static List<GraphNode> sortedTopology(Graph graph){
        // key-某一个GraphNode,value-剩余的入度
        HashMap<GraphNode,Integer> inMap = new HashMap<>();
        // 入度为0才可进入队列
        Queue<GraphNode> zeroInQueue = new LinkedList<>();
        for (GraphNode node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        // 拓扑排序结果,依次加入result
        List<GraphNode> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            GraphNode cur = zeroInQueue.poll();
            result.add(cur);
            for (GraphNode next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
