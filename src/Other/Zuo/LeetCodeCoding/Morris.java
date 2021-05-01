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
 *
 * 先序遍历:只打印第一次到达的节点
 * 中序遍历:先打印没有左树的节点,再打印第二次到达的节点
 * 后序遍历:
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
    // 中序遍历
    public static void morrisIn(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){// 有左树
                // 找cur的左树的最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // 右指针指向null,能够第二次到达自己的节点
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{// 右指针指向cur
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }
    // 先序遍历
    public static void morrisPre(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){// 有左树
                // 找cur的左树的最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // 右指针指向null,能够第二次到达自己的节点
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value+" ");
                    cur = cur.left;
                    continue;
                }else{// 右指针指向cur
                    mostRight.right = null;
                }
            }
            else{
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }
    // 后序遍历
    public static void morrisPos(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){// 有左树
                // 找cur的左树的最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // 右指针指向null,能够第二次到达自己的节点
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{// 右指针指向cur
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while(cur != null){
            System.out.print(cur.value+" ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while(from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
}
