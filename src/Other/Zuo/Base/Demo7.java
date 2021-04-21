package Other.Zuo.Base;

/**
 * @title: Demo7
 * @Author: Lux_er
 * @Date: 2021/4/16 0016 上午 10:52
 * @Description:
 * 判断链表是否回文,要求空间复杂度为O(1)
 */
public class Demo7 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int N = utils.inputNumber();
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < N; i++) {
            temp.next = new ListNode(utils.inputNumber());
            temp = temp.next;
        }
        boolean res = isPalindrome(head);
        System.out.println(res);
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 定义快慢指针
        ListNode n1 = head;
        ListNode n2 = head;
        // 循环判断条件很重要
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res= true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
