package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/15 - 16:25
 * @Description:
 * 题目描述
 * 大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。
 * 大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，
 * 因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是第4个字母'D'，代表星期四；
 * 第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、以及大写字母A到N表示）；
 * 后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。
 * 现给定两对字符串，请帮助福尔摩斯解码得到约会的时间。
 *
 * 输入描述:
 * 输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。
 *
 * 输出描述:
 * 在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
 * 四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。
 *
 * 输入例子:
 * 3485djDkxh4hhGE
 * 2984akDfkkkkggEdsb
 * s&hgsfdk
 * d&Hyscvnm
 *
 * 输出例子:
 * THU 14:04
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.next();
        String text2 = scanner.next();
        String text3 = scanner.next();
        String text4 = scanner.next();
        char week = 'A';
        char time1 = 'A';
        int time2 = 0;
        int length1 = text1.length() > text2.length() ? text1.length() : text2.length();
        int length2 = text3.length() > text4.length() ? text3.length() : text4.length();
        boolean isFirst = true;
        boolean end1 = false;
        boolean end2 = false;
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        char[] arr3 = text3.toCharArray();
        char[] arr4 = text4.toCharArray();

        for(int i = 0;i < length1;i++){
            if( isCapital(arr1[i]) && arr1[i] - arr2[i] == 0 && isFirst == true){
                week = arr1[i];
                isFirst = false;
                continue;
            }else if(arr1[i] - arr2[i] == 0 && isFirst == false){
                time1 = arr1[i];
                break;
            }
        }

        for(int i = 0;i < length2;i++){
            if(!isEnglish(arr3[i])){
                continue;
            }
            if(arr3[i] - arr4[i] == 0){
                time2 = i;
                break;
            }
        }

        switch (week){
            case 'A':
                System.out.print("MON ");
                break;
            case 'B':
                System.out.print("TUE ");
                break;
            case 'C':
                System.out.print("WED ");
                break;
            case 'D':
                System.out.print("THU ");
                break;
            case 'E':
                System.out.print("FRI ");
                break;
            case 'F':
                System.out.print("SAT ");
                break;
            case 'G':
                System.out.print("SUN ");
                break;
        }
        if(isNum(time1)){
            System.out.print("0"+time1+":");
        }else{
            int res = time1 - 'A'+ 10;
            System.out.print(res+":");
        }
        if(time2 >= 0 && time2 <= 9){
            System.out.print("0"+time2);
        }else{
            System.out.println(time2);
        }
    }

    private static boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    private static  boolean isEnglish(char c){
        return isCapital(c) || (c >= 'a' && c <= 'z');
    }
}
