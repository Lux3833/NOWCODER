package Other.Zuo.LeetCodeCoding;

/**
 * @title: Morris
 * @Author: Lux_er
 * @Date: 2021/4/28 0028 下午 7:52
 * @Description:Morri s遍历,时间复杂度O(N),空间复杂度O(1)
 * 设当前节点cur,一开始cur来到整棵树的头节点
 * 1)cur无左树,cur = cur.right
 * 2)cur有左树,找到左树最右节点,设为mostright
 * ①如果mostright的右指针指向null的,令mostright.right = cur,cur = cur.left
 * ②如果mostright的右指针指向cur的,令mostright.right = null,cur = cur.right
 */
public class Morris {
    private static class Node{
        public int value;
        Node left;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }
    /*public static void process(Node head){
        if(head == null){
            return;
        }
        process(head.left);
        process(head.right);
    }*/
    public static void morrisIn(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != null){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }
}
