package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 15:29
 * @Description: 题目描述
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？
 * <p>
 * 输入描述:
 * 输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
 * 注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
 * <p>
 * 输入例子:
 * 7+IE.
 * 7_This_is_a_test.
 * <p>
 * 输出例子:
 * _hs_s_a_tst
 */
public class Test23 {
    static boolean isShiftError = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String errorKey = scanner.next();
        String typeWords = scanner.next();
        if (errorKey.contains("+")) {
            isShiftError = true;
        }
        if (isShiftError) {
            errorKey = errorKey.toLowerCase();
            typeWords = cutCapital(typeWords);
        }
        String out = typeWords;
        for (int i = 0; i < errorKey.length(); i++) {
            String key = errorKey.charAt(i) + "";
            String[] sp = null;
            if (out.contains(key.toLowerCase()) || out.contains(key.toUpperCase())) {
                if(key.equals(",") || key.equals(".") || key.equals("-")){
                    switch (key){
                        case ",":
                            key = ",";
                            break;
                        case ".":
                            key = "\\.";
                            break;
                        case "-":
                            key = "-";
                            break;
                    }
                    sp = out.split(key);
                    String temp = "";
                    for (String str : sp) {
                        temp += str;
                    }
                    out = temp;
                }else{
                   if(out.contains(key.toLowerCase())){
                       sp = out.split(key.toLowerCase());
                       String temp = "";
                       for (String str : sp) {
                           temp += str;
                       }
                       out = temp;
                   }
                   if(out.contains(key.toUpperCase())){
                       sp = out.split(key.toUpperCase());
                       String temp = "";
                       for (String str : sp) {
                           temp += str;
                       }
                       out = temp;
                   }
                }

            }
        }
        System.out.print(out);
    }

    private static String cutCapital(String typeWords) {
        char[] arr = typeWords.toCharArray();
        String back = "";
        for(int i = 0;i < arr.length;i++){
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                continue;
            }
            back += arr[i]+"";
        }
        return back;
    }
}
