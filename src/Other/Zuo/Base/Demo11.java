package Other.Zuo.Base;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @title: Demo11
 * @Author: Lux_er
 * @Date: 2021/4/20 0020 下午 3:03
 * @Description:
 * 给定两个二叉树的节点node1和node2,找到他们的最低公共祖先节点
 */
public class Demo11 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        TreeNode[] treeList = new TreeNode[N];
        TreeNode root = new TreeNode(utils.inputNumber());
        treeList[0] = root;
        TreeNode head = create(root,treeList,0);
    }

    private static TreeNode create(TreeNode treeNode,TreeNode[] treeList,int i) {
      if(i < treeList.length){
         TreeNode lchild = new TreeNode(new Utils().inputNumber());
         TreeNode rchild = new TreeNode(new Utils().inputNumber());
         if(treeNode != null){
             treeNode.left = create(lchild,treeList,++i);
             treeList[i] = treeNode.left;
             treeNode.right = create(rchild, treeList, ++i);
             treeList[i] = treeNode.right;
         }
      }
      return treeNode;
    }

    public static TreeNode lca(TreeNode head,TreeNode o1,TreeNode o2){
        HashMap<TreeNode,TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head,fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();

        TreeNode cur = o1;
        while(cur != fatherMap.get(cur)){
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        TreeNode res = fatherMap.get(o2);
        while(res != head){
            if(set1.contains(res)){
                return res;
            }else{
                res = fatherMap.get(res);
            }
        }
        return head;
    }
    public static void process(TreeNode head, HashMap<TreeNode,TreeNode> fatherMap){
        if(head == null){
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }
}
