package Other.Zuo.Base.Graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @title: Graph
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 上午 11:07
 * @Description:
 */
public class Graph {
    public HashMap<Integer,GraphNode> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
