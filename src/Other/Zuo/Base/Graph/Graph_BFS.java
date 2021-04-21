package Other.Zuo.Base.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @title: Graph_BFS
 * @Author: Lux_er
 * @Date: 2021/4/21 0021 下午 1:29
 * @Description:
 */
public class Graph_BFS {
    // 从GraphNode出发,进行宽度优先遍历
    public static void bfs(GraphNode node){
        if(node == null){
            return;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            System.out.println(cur.value);
            for (GraphNode next : cur.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
