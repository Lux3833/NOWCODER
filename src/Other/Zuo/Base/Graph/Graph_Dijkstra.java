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
    // 从head出发,所有能到达的节点,生成到达每个节点的最小路径记录并返回
    public static HashMap<GraphNode,Integer> dijkstra2(GraphNode head,int size){
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);
        HashMap<GraphNode,Integer> result = new HashMap<>();
        while(!nodeHeap.isEmpty()){
            NodeRecord record = nodeHeap.pop();
            GraphNode cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to,edge.weight+distance);
            }
            result.put(cur,distance);
        }
        return result;
    }

    private static class NodeRecord {
        public GraphNode node;
        public int distance;// 到达node节点的距离

        public NodeRecord(GraphNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    private static class NodeHeap {
        private GraphNode[] nodes;
        // 节点在堆中位置
        private HashMap<GraphNode,Integer> heapIndexMap;
        private HashMap<GraphNode,Integer> distanceMap;
        private int size;

        public NodeHeap(int size){
            nodes = new GraphNode[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void addOrUpdateOrIgnore(GraphNode node,int distance){
            if(inHeap(node)){
                distanceMap.put(node, Math.min(distanceMap.get(node),distance));
                insertHeapify(node,heapIndexMap.get(node));
            }
            if(!isEntered(node)){
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node,size++);
            }
        }
        public NodeRecord pop(){
            NodeRecord nodeRecord = new NodeRecord(nodes[0],distanceMap.get(nodes[0]));
            swap(0, size-1);
            heapIndexMap.put(nodes[size-1],-1);
            distanceMap.remove(nodes[size-1]);
            nodes[size-1] = null;
            heapify(0,--size);
            return nodeRecord;
        }
        private void insertHeapify(GraphNode node,int index){
            while(distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index-1)/2])){
                swap(index, (index-1)/2);
                index = (index-1)/2;
            }
        }
        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while(left < size){
                int smallest = left + 1 < size && distanceMap.get(nodes[left+1])<distanceMap.get(nodes[left])
                        ? left+1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if(smallest == index){
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        // 判断node节点是否被记录在hashmap中
        private boolean isEntered(GraphNode node){
            return heapIndexMap.containsKey(node);
        }
        // 判断node是否在堆中,要求进来过堆,但是已经被弹出,位置变为-1
        private boolean inHeap(GraphNode node){
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }
        // 交换堆中两个节点的位置
        private void swap(int index1,int index2){
            // 修改heapIndexMap中的位置信息
            heapIndexMap.put(nodes[index1],index2);
            heapIndexMap.put(nodes[index2],index1);
            // 交换堆中的两个节点位置
            GraphNode tmp = nodes[index2];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }
}
