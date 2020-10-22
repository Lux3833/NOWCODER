package PATII;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/22 - 23:12
 * @Description:
 * 题目描述
 * 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
 *  首先对前17位数字加权求和，权重分配为：{7，9，10，5，8，4，2，1，6，3，7，9，10，5，8，4，2}；然后将计算的和对11取模得
 *  到值Z；最后按照以下关系对应Z值与校验码M的值：
 *  Z：0 1 2 3 4 5 6 7 8 9 10
 *  M：1 0 X 9 8 7 6 5 4 3 2
 *  现在给定一些身份证号码，请你验证校验码的有效性，并输出有问题的号码。
 *
 * 输入描述:
 * 输入第一行给出正整数N（<= 100）是输入的身份证号码的个数。随后N行，每行给出1个18位身份证号码。
 *
 *
 * 输出描述:
 * 按照输入的顺序每行输出1个有问题的身份证号码。这里并不检验前17位是否合理，只检查前17位是否全为数字且最后1位校验码计算准确。如果所有号码都正常，
 *
 * 则输出“All passed”。
 *
 * 输入例子:
 * 4
 * 320124198808240056
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 *
 * 输出例子:
 * 12010X198901011234
 * 110108196711301866
 * 37070419881216001X
 */
public class Test21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] weight = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        String[] str = new String[N];
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i < N;i++){
            str[i] = scanner.next();

        }
        scanner.close();
        for(int i = 0;i < N;i++){
            if(isError(str[i].substring(0,17))){
                arr.add(str[i]);
            }else if(isCheckedError(str[i],weight)){
                arr.add(str[i]);
            }
        }
        if(arr.size() == 0){
            System.out.print("All passed");
        }else{
            for(int i = 0;i < arr.size();i++){
                System.out.println(arr.get(i));
            }
        }
    }

    private static boolean isCheckedError(String s,int[] weight) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for(int i = 0;i < arr.length-1;i++){
           sum += weight[i] * (arr[i] - '0');
        }
        sum = sum % 11;
        String M = "";
        switch (sum){
            case 0:
                M = "1";
                break;
            case 1:
                M = "0";
                break;
            case 2:
                M = "X";
                break;
            case 3:
                M = "9";
                break;
            case 4:
                M = "8";
                break;
            case 5:
                M = "7";
                break;
            case 6:
                M = "6";
                break;
            case 7:
                M = "5";
                break;
            case 8:
                M = "4";
                break;
            case 9:
                M = "3";
                break;
            case 10:
                M = "2";
                break;
        }
        String check = arr[arr.length-1]+"";
        if(check.equals(M)){
            return false;
        }else{
            return true;
        }
    }

    private static boolean isError(String substring) {
        char[] arr = substring.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(!Character.isDigit(arr[i])){
                return true;
            }
        }
        return false;
    }
}
