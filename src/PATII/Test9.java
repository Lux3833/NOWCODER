package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/16 - 10:28
 * @Description:
 * 题目描述
 * 给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到
 *  一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
 *
 *  例如，我们从6767开始，将得到
 *
 *  7766 - 6677 = 1089
 *  9810 - 0189 = 9621
 *  9621 - 1269 = 8352
 *  8532 - 2358 = 6174
 *  7641 - 1467 = 6174
 *  ... ...
 *
 *  现给定任意4位正整数，请编写程序演示到达黑洞的过程。
 *
 * 输入描述:
 * 输入给出一个(0, 10000)区间内的正整数N。
 *
 *
 * 输出描述:
 * 如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。注意每个数字按4位数格
 *  式输出。
 *
 * 输入例子:
 * 6767
 *
 * 输出例子:
 * 7766 - 6677 = 1089
 *  9810 - 0189 = 9621
 *  9621 - 1269 = 8352
 *  8532 - 2358 = 6174
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        if(str.length() !=4){
            int count = 4-str.length();
            for(int i = 0;i < count;i++){
                str += "0";
            }
        }
        char[] arr = str.toCharArray();
        int value = 0;
        do{
            if(isEuqal(arr)){
                String s = "";
                for(char c:arr){
                    s += c;
                }
                System.out.print(s+" - "+s+" = 0000");
                break;
            }
            value = Integer.parseInt(sort(arr,1))  - Integer.parseInt(sort(arr,0));
            if(sort(arr,0).length() !=4){
                int count = 4 - sort(arr,0).length();
                System.out.print(sort(arr,1)+" - ");
                for(int i = 0;i < count;i++){
                    System.out.print("0");
                }
                System.out.println(sort(arr,0)+" = "+value);
            }
            System.out.println(sort(arr,1)+" - "+sort(arr,0)+" = "+value);
            arr = String.valueOf(value).toCharArray();
        }while(value != 6174);
    }
    public static String sort(char[] arr,int flag){//flag==1,降序，flag==0,升序
        char temp = '0';
        for(int i = 1;i < arr.length;i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (flag == 1) {
                    if (arr[j] < arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                } else {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        String res = "";
        for(char c : arr){
            res += c;
        }
        return res;
    }
    public static boolean isEuqal(char[] arr){
        boolean flag = true;
        char temp = arr[0];
        for(char c: arr){
            if(c != temp){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
