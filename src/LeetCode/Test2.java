package LeetCode;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/24 - 12:32
 * @Description:
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr1 = new int[M];
        int[] arr2 = new int[N];
        for(int i = 0;i < M;i++){
            arr1[i] = scanner.nextInt();
        }
        for(int j = 0;j < N;j++){
            arr2[j] = scanner.nextInt();
        }
        scanner.close();
        Node l1 = new Node(-1);
        Node l2 = new Node(-1);
        Node temp1 = l1;
        Node temp2 = l2;
        for(int i = 0;i < M;i++){
            temp1.val = arr1[i];
            if(i != M-1){
                temp1.next = new Node(arr1[i+1]);
                temp1 = temp1.next;
            }else{
                temp1.next = null;
                temp1 = temp1.next;
            }

        }
        for(int j = 0;j < N;j++){
            temp2.val = arr2[j];
            if(j != N-1){
                temp2.next = new Node(arr1[j+1]);
                temp2 = temp2.next;
            }else{
                temp2.next = null;
                temp2 = temp2.next;
            }

        }
        int sum = 0;
        Node p = l1;
        Node q = l2;
        Node l3 = new Node(-1);
        Node temp3 = l3;
        boolean carry = false;
        while (p != null || q != null){
            sum = 0;
            if(p != null){
                sum += p.val;
                p = p.next;
            }
            if(q != null){
                sum += q.val;
                q = q.next;
            }
            if(carry) sum++;
            temp3.next = new Node(sum % 10);
            temp3 = temp3.next;
            carry = sum >= 10 ? true:false;
        }
        if(carry){
            temp3.next = new Node(1);
            temp3 = temp3.next;
        }
        while (l3.next != null){
            System.out.print(l3.next.val+" ");
            l3 = l3.next;
        }
    }
}
class Node{
    public int val;
    public Node next = null;
    public Node(){};
    public Node(int val){
        this.val = val;
    }
    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}