package LeetCode.Test01_60;



import LeetCode.Utils.Utils;
import LeetCode.Utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @title: Test19
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:14
 * @Description:
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Test19 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        ListNode head = new ListNode();
        ListNode temp = head;
        int N = utils.inputNumber();
        for (int i = 0; i < N; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        int n = utils.inputNumber();
        ListNode res = removeNthFromEnd(head,n);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
