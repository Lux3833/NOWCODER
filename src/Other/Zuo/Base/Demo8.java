package Other.Zuo.Base;

/**
 * @title: Demo8
 * @Author: Lux_er
 * @Date: 2021/4/16 0016 下午 12:00
 * @Description:
 * 使用快慢指针判断链表是否有环,如果有,返回第一个环节点
 */
public class Demo8 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        ListNode head = new ListNode();
        ListNode temp = head;
        for(int i = 0;i < N;i++){
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        ListNode loopNode = getLoopNode(head.next);
        System.out.println(loopNode);
    }

    private static ListNode getLoopNode(ListNode node) {
        if(node == null || node.next == null || node.next.next == null){
            return null;
        }
        // 慢指针
        ListNode n1 = node.next;
        // 快指针
        ListNode n2 = node.next.next;
        while(n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = node;
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
