package Other.Zuo.Base.Graph;

import java.util.ArrayList;

/**
 * @title: GraphNode
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 上午 11:04
 * @Description:
 */
public class GraphNode {
    // 点代表的内容
    public int value;
    public int in;
    public int out;
    public ArrayList<GraphNode> nexts;
    public ArrayList<Edge> edges;

    public GraphNode(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
