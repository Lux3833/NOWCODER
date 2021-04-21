package Other.Zuo.Base.Graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @title: Graph_DFS
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 1:43
 * @Description:
 */
public class Graph_DFS {
    public static void dfs(GraphNode node){
        if(node == null){
            return;
        }
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> set = new HashSet<>();
        stack.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            GraphNode cur = stack.pop();
            for (GraphNode next : cur.nexts) {
                stack.push(cur);
                stack.push(next);
                set.add(next);
                System.out.println(next.value);
                break;
            }
        }
    }
}
