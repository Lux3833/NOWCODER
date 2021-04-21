package Other.Zuo.Base.Graph;

/**
 * @title: GraphGenerator
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 1:13
 * @Description:
 */
public class GraphGenerator {
    // 通过邻接矩阵来构建图
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new GraphNode(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new GraphNode(to));
            }
            GraphNode fromNode = graph.nodes.get(from);
            GraphNode toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
