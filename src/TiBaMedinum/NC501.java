package TiBaMedinum;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/27 - 21:58
 * @Description:
 * 题目描述
 * 题目背景：
 *
 * “曾经有两次消除的机会摆在我面前，我却没有珍惜……”牛牛回忆道。
 * 牛牛正在玩一款全新的消消乐游戏。这款游戏的主体是由一列列的方块构成，牛牛的目标就是要尽量消除这些方块。
 * 每次操作，牛牛可以选择某个高度 x，将所有高度大于等于 x 的那些列全部消除 x 个方块，随后方块会下落，以填补消除造成的空白。
 * 牛牛这一局的发挥极佳，眼看就要破纪录了，却发现自己只剩下了两次消除机会。
 * 为了不错失这千载难逢的机会，他决定写个程序来算出最优解。
 *
 *
 * 简明题意：
 *
 * 给定一个数组 nums，其中有 n 个非负整数。你的目的是进行两次操作，使得数组的元素之和最小。
 * 每次操作形如：任选一个整数 x ，将数组中所有大于等于 x 的数减去 x 。
 */
public class NC501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        int[] res = new int[n];
        res = operate(nums);
        res = operate(nums);
        int result = 0;
        for(int i : res){
            result += i;
        }
        System.out.print(result);
    }

    private static int[] operate(int[] nums) {
        int len = nums.length;
        int[] back = new int[len];
        int[] temp = nums.clone(); 
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                if(temp[i] > nums[j]){

                }
            }
        }
        return back;
    }
}
