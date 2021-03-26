package LeetCode;

/**
 * @title: Test24
 * @Author: Lux_er
 * @Date: 2021/3/26 0026 上午 9:00
 * @Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Test24 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp = head;
        Utils utils = new Utils();
        int n = utils.inputNumber();
        for (int i = 0; i < n; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        temp = swapPairs(head);
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
