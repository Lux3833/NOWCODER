package Other.Zuo.Base;

import java.util.Scanner;

/**
 * @title: Utils
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:27
 * @Description:
 */
public class Utils {
    public int[] inputNums(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }
    public int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }
    public String inputStr(){
        Scanner scanner = new Scanner(System.in);
        return  scanner.next();
    }
    public void printNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public String[] inputStrs(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        return strs;
    }
    public double intputDouble(){
        Scanner scanner = new Scanner(System.in);
        double res = scanner.nextDouble();
        return res;
    }
    public void swap(int[] arr,int i,int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class ListNode {
    int val; ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
    }
}