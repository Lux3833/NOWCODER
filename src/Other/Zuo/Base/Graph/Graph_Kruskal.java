package Other.Zuo.Base.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @title: Graph_Kruskal
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 3:26
 * @Description:适用范围:无向图
 */
public class Graph_Kruskal {
    public static class MySets{
        public HashMap<GraphNode, List<GraphNode>> setMap;
        public MySets(List<GraphNode> nodes){
            for (GraphNode cur : nodes) {
                List<GraphNode> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }
        public boolean isSameSete(GraphNode from,GraphNode to){
            List<GraphNode> fromSet = setMap.get(from);
            List<GraphNode> toSet = setMap.get(to);
            return fromSet == toSet;
        }
        public void union(GraphNode from,GraphNode to){
            List<GraphNode> fromSet = setMap.get(from);
            List<GraphNode> toSet = setMap.get(to);
            for (GraphNode toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
        public static Set<Edge> kruskalMST(Graph graph){
           return null;
        }
    }
}
