package LeetCode;

/**
 * @title: Test21
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:24
 * @Description:
 */
public class Test21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        Utils utils = new Utils();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        
        int n1 = utils.inputNumber();
        for (int i = 0; i < n1; i++) {
            temp1.next = new ListNode(utils.inputNumber());
            temp1 = temp1.next;
        }
        int n2 = utils.inputNumber();
        for (int i = 0; i < n2; i++) {
            temp2.next = new ListNode(utils.inputNumber());
            temp2 = temp2.next;
        }
        ListNode l3 = mergeTwoLists(l1,l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode merge = new ListNode();
        ListNode temp3 = merge;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp3.next = head1;
                head1 = head1.next;
            }else{
                temp3.next = head2;
                head2 = head2.next;
            }
            temp3 = temp3.next;
        }
        temp3.next = head1 == null ? head2 : head1;
        return merge.next;
    }
}
