package LeetCode.Test61_120;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.Utils;

/**
 * @title: Test83
 * @Author: Lux_er
 * @Date: 2021/5/19 0019 下午 2:49
 * @Description:删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 示例：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Test83 {
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

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
