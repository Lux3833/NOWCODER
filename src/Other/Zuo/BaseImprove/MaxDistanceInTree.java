package Other.Zuo.BaseImprove;

/**
 * @title: MaxDistanceInTree
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 7:56
 * @Description:叉树节点间的最大距离问题
 * 从二叉树的节点a出发,可以向上或者向下走,但沿途的节点只能经过一次,到达
 * 节点b时路径上的节点个数叫做a到b的距离,求整棵树上的最大距离.
 * 分析:
 * 两种情况
 * ①根节点不参与:最大距离是左子树路径的最大距离或者是右子树路径的最大距离
 * ②根节点参与:左子树的高+1+右子树的高
 */
public class MaxDistanceInTree {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static int maxDistance(Node head){
        return process(head).maxDistance;
    }
    // 返回以x为头的整棵树的Info信息
    private static Info process(Node x) {
        if(x == null){
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height+ 1 + rightInfo.height;
        int maxDistance = Math.max(p3,Math.max(p1,p2));
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        return new Info(maxDistance,height);
    }

    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int dis,int h){
            this.maxDistance = dis;
            this.height = h;
        }
    }
}
