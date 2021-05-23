package LeetCode.Test61_120;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.Utils;

/**
 * @title: Test82
 * @Author: Lux_er
 * @Date: 2021/5/19 0019 上午 11:05
 * @Description:删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 * 示例：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class Test82 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        ListNode head = new ListNode(utils.inputNumber());
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        head = deleteDuplicates(head);
        utils.printListNode(head);
    }
    // 由于链表的头节点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点。
    public static ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int x = cur.next.val;
                    while (cur.next != null && cur.next.val == x) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
    }
}
