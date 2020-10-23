package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 21:10
 * @Description: 题目描述
 * 字符串APPAPT中包含了两个单词“PAT”，其中第一个PAT是第2位(P),第4位(A),第6位(T)；第二个PAT是第3位(P),第4位(A),第6位(T)。
 * <p>
 * 现给定字符串，问一共可以形成多少个PAT？
 * <p>
 * 输入描述:
 * 输入只有一行，包含一个字符串，长度不超过105，只包含P、A、T三种字母。
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出给定字符串中包含多少个PAT。由于结果可能比较大，只输出对1000000007取余数的结果。
 * <p>
 * 输入例子:
 * APPAPT
 * <p>
 * 输出例子:
 * 2
 */
public class Test30 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int pcount = 0;
        int pacount = 0;
        int totalcount = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'P') {
                pcount++;
            } else if (c == 'A') {
                pacount += pcount;
            } else {
                totalcount += pacount;
                totalcount %= 1000000007;
            }
        }
        System.out.println(totalcount);
    }
}
