package LeetCode.Test61_120;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Test86
 * @Author: Lux_er
 * @Date: 2021/5/20 0020 上午 9:36
 * @Description:分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Test86 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        ListNode head = new ListNode(utils.inputNumber());
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        int x = utils.inputNumber();
        head = partition(head, x);
        utils.printListNode(head);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        ArrayList<ListNode> small = new ArrayList<>();
        ArrayList<ListNode> big = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                small.add(new ListNode(temp.val));
            }else{
                big.add(new ListNode(temp.val));
            }
            temp = temp.next;
        }
        if(small.size() > 0){
            temp = small.get(0);
            head = temp;
            for (int i = 1; i < small.size(); i++) {
                temp.next = small.get(i);
                temp = temp.next;
            }
            for (int i = 0; i < big.size(); i++) {
                temp.next = big.get(i);
                temp = temp.next;
            }
        }else{
            temp = big.get(0);
            head = temp;
            for (int i = 1; i < big.size(); i++) {
                temp.next = big.get(i);
                temp = temp.next;
            }
        }
        return head;
    }
    //直观来说我们只需维护两个链表 small 和 large 即可，small 链表按顺序存储所有小于 xx 的节点，
    // large 链表按顺序存储所有大于等于 xx 的节点。遍历完原链表后，
    // 我们只要将 small 链表尾节点指向 large 链表的头节点即能完成对链表的分隔。
    public static ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
