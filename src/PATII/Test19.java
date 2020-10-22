package PATII;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/22 - 21:21
 * @Description:
 * 题目描述
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
 * 肯定坏掉的那些键。
 *
 * 输入描述:
 * 输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、
 * 以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。
 *
 *
 * 输出描述:
 * 按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。
 *
 * 输入例子:
 * 7_This_is_a_test
 * _hs_s_a_es
 *
 * 输出例子:
 * 7TI
 */
public class Test19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        for(int i = 0;i < arr1.length;i++){
            if(index < arr2.length){
                if(arr1[i] != arr2[index]){
                    if(isNotExist(arr1[i],list)){
                        String str = arr1[i]+"";
                        list.add(str.toUpperCase());
                    }
                }else{
                    index++;
                }
            }else{
                if(isNotExist(arr1[i],list)){
                    String str = arr1[i]+"";
                    list.add(str.toUpperCase());
                }
            }
        }
        for(String str : list){
            System.out.print(str);
        }
    }

    private static boolean isNotExist(char c, ArrayList<String> list) {
        String str = c+"";
        if(list.contains(str.toUpperCase())){
            return false;
        }else{
            return true;
        }
    }
}
