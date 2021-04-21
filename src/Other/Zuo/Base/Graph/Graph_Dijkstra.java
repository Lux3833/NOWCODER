package Other.Zuo.Base.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @title: Graph_Dijkstra
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 4:22
 * @Description:适用范围:不能有累加和为负数的环
 */
public class Graph_Dijkstra {
    public static HashMap<GraphNode,Integer> dijkstral(GraphNode head){
        // 从head出发到所有点的最小距离
        // key:从head出发到达key
        // value:从head出发到达key的最小距离
        // 如果在表中,没有T的记录,含义是从head出发到T这个点的距离为正无穷
        HashMap<GraphNode,Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经求过距离的节点,存在selectedNodes中,以后不再使用
        HashSet<GraphNode> selectedNodes = new HashSet<>();
        GraphNode minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        while(minNode != null){
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                GraphNode toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance+edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode),
                        distance+edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    private static GraphNode getMinDistanceAndUnselectedNode(
            HashMap<GraphNode, Integer> distanceMap, HashSet<GraphNode> selectedNodes) {
            GraphNode minNode = null;
            int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<GraphNode, Integer> entry : distanceMap.entrySet()) {
            GraphNode node = entry.getKey();
            int distance = entry.getValue();
            if(!selectedNodes.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
              return minNode;
    }
}
