package Other.Zuo.Base;

import java.util.LinkedList;

/**
 * @title: Demo10
 * @Author: Lux_er
 * @Date: 2021/4/20 0020 上午 9:39
 * @Description:
 * 如何判断一颗二叉树是否是搜索二叉树?
 * 如何判断一颗二叉树是否是完全二叉树?
 * 如何判断一颗二叉树是否是满二叉树?
 * 如何判断一颗二叉树是否是平衡二叉树?
 */
public class Demo10 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        TreeNode head = new TreeNode();
        TreeNode temp = head;
        for(int i = 0;i < N;i++){
            temp.left = new TreeNode(utils.inputNumber());
            temp.right = new TreeNode(utils.inputNumber());
        }
        boolean isBST = checkBST(head);
        boolean isCBT = checkCBT(head);
        boolean isFull = isFull(head);
        boolean isBalcanced = isBalanced(head);

        System.out.println("该树是否为搜索二叉树: "+isBST);
        System.out.println("该树是否为完全二叉树: "+isCBT);
        System.out.println("该树是否为满二叉树: "+isFull);
        System.out.println("该树是否为平衡二叉树: "+isBalcanced);
    }

    private static int preValue = Integer.MIN_VALUE;
    // 判断是否是搜索二叉树
    private static boolean checkBST(TreeNode head) {
        if(head == null){
            return true;
        }
        boolean isLeftBst = checkBST(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.val <= preValue){
            return false;
        }else{
            preValue = head.val;
        }
        return checkBST(head.right);
    }
    // 判断是否是完全二叉树:1)任一节点,有右子树无左子树,不是完全二叉树,2)满足1)的情况下
    // 如果遇到了第一个左右子树不全,后续的节点都必须是叶子节点
    private static boolean checkCBT(TreeNode head) {
        if(head == null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if( (leaf && (l != null || r != null))
                || (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }
    // 判断是否是满二叉树
    public static boolean isFull(TreeNode head){
        if(head == null){
            return true;
        }
        Info data = f(head);
        return data.nodes == (1 << data.height - 1);
    }
    public static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
    public static Info f(TreeNode x){
        if(x == null){
            return new Info(0, 0);
        }
        Info leftData = f(x.left);
        Info rightData = f(x.right);
        int height = Math.max(leftData.height, rightData.height)+1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }
    // 判断是否是平衡二叉树
    public static boolean isBalanced(TreeNode head){
        return process(head).isBalanced;
    }
    // 创建新class,记录平衡状态和当前高度
    public static class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(TreeNode x){
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height,rightData.height)+1;
        // 当前节点的平衡条件:左子树是平衡的;右子树是平衡的;左右子树之差的绝对值不大于2
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                        && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}
