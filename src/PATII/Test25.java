package PATII;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 16:52
 * @Description: 题目描述
 * 根据维基百科的定义：
 * <p>
 * 插入排序是迭代算法，逐一获得输入数据，逐步产生有序的输出序列。每步迭代中，算法从输入序列中取出一元素，将之插入有序序列中正确
 * 的位置。如此迭代直到全部元素有序。
 * <p>
 * 归并排序进行如下迭代操作：首先将原始序列看成N个只包含1个元素的有序子序列，然后每次迭代归并两个相邻的有序子序列，直到最后只剩
 * 下1个有序的序列。
 * <p>
 * 现给定原始序列和由某排序算法产生的中间序列，请你判断该算法究竟是哪种排序算法？
 * <p>
 * 输入描述:
 * 输入在第一行给出正整数N (<=100)；随后一行给出原始序列的N个整数；最后一行给出由某排序算法产生的中间序列。这里假设排序的目标序列是升序。数字间以
 * 空格分隔。
 * <p>
 * <p>
 * 输出描述:
 * 首先在第1行中输出“Insertion Sort”表示插入排序、或“Merge Sort”表示归并排序；然后在第2行中输出用该排序算法再迭代一轮的结果序列。题目保证每组测试
 * 的结果是唯一的。数字间以空格分隔，且行末不得有多余空格。
 * <p>
 * 输入例子:
 * 10
 * 3 1 2 8 7 5 9 4 6 0
 * 1 2 3 7 8 5 9 4 6 0
 * <p>
 * 输出例子:
 * Insertion Sort
 * 1 2 3 5 7 8 9 4 6 0
 */
public class Test25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            temp[i] = scanner.nextInt();
        }
        String type = "Insertion Sort";
        //插入排序
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] > temp[i + 1]) {
                index = i + 1;//从这里开始无序
                break;
            }
        }
        for (int j = index; j < n; j++) {
            if (arr[j] != temp[j]) {//若两者不相同，则说明不是插入排序
                type = "Merge Sort";
                break;
            }
        }
        if (type.equals("Insertion Sort")) {//若是插入排序
            int num = temp[index];
            for (int j = index; j > 0; j--) {
                if (temp[j] < temp[j - 1]) {
                    temp[j] = temp[j - 1];
                    temp[j - 1] = num;
                }
            }
        } else {
            //如果是归并排序 index的值表示这么多的规模已经排序完，
            index = 2 * index;
            for (int i = 0; i < n; i += index) {
                int next = i + index > n ? n : i + index;
                Arrays.sort(temp, i, next);
            }
        }
        System.out.println(type);
        for(int i = 0;i < temp.length-1;i++){
            System.out.print(temp[i]+" ");
        }
        System.out.print(temp[n-1]);
    }
}
