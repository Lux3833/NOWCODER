package Other.Zuo.Base;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @title: Demo9
 * @Author: Lux_er
 * @Date: 2021/4/19 0019 上午 11:44
 * @Description:
 * 采用非递归的方式遍历二叉树
 */
public class Demo9 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        TreeNode head = new TreeNode();
        TreeNode temp = head;
        for(int i = 0;i < N;i++){
            temp.left = new TreeNode(utils.inputNumber());
            temp.right = new TreeNode(utils.inputNumber());
        }
        preOrderUnReCurl(head);
        inOrderUnRecurl(head);
        posOrderUnRecurl(head);
        w(head);
    }
    // 层次遍历
    private static void w(TreeNode head) {
        if(head == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        // 哈希表存储每个节点对应的层数
        HashMap<TreeNode,Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        // 记录最大层个数
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else{
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if(cur.left != null){
                levelMap.put(cur.left, curNodeLevel++);
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right, curNodeLevel++);
                queue.add(cur.right);
            }
        }
    }

    private static void preOrderUnReCurl(TreeNode node) {
        System.out.print("先序遍历结果:");
        if(node != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(node);
            while(!stack.empty()){
                node = stack.pop();
                System.out.print(node.val+" ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        System.out.println();
    }
    // 中序:每棵子树的整棵树的左边界全部进栈,依次弹出并打印,如果弹出的节点有右子树,则重复该过程
    private static void inOrderUnRecurl(TreeNode head) {
        System.out.print("中序遍历结果:");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.val+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    private static void posOrderUnRecurl(TreeNode head) {
        System.out.print("后序遍历结果:");
        if(head != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.empty()) {
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.empty()) {
                System.out.print(s2.pop().val+" ");
            }
        }
        System.out.println();
    }

}
