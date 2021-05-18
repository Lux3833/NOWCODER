package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test61
 * @Author: Lux_er
 * @Date: 2021/5/13 0013 下午 6:59
 * @Description:旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class Test61 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < N; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        int k = utils.inputNumber();
        head = rotateRight(head.next, k);
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode end = head;
        int count = 1;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        end = temp;
        k = k % count;
        if(k  == 0){
            return head;
        }
        temp = head;
        while(count - k > 1){
            temp = temp.next;
            k++;
        }
        end.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
