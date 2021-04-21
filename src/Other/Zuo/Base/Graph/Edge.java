package Other.Zuo.Base.Graph;

/**
 * @title: Edge
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 上午 11:09
 * @Description:
 */
public class Edge {
    public int weight;
    public GraphNode from;
    public GraphNode to;

    public Edge(int weight,GraphNode from,GraphNode to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
