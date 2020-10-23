package PATII;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 19:03
 * @Description:
 * 题目描述
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
 * 下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 *
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
 * 全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 *
 *
 * 输出描述:
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
 *
 * 输入例子:
 * ppRYYGrrYBR2258
 * YrR8RrY
 *
 * 输出例子:
 * Yes 8
 */
public class Test29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sell = scanner.next();
        String want = scanner.next();
        scanner.close();

        char[] arr1 = sell.toCharArray();
        char[] arr2 = want.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < arr1.length;i++){
            if(map.containsKey(arr1[i])){
                int count = map.get(arr1[i]);
                map.replace(arr1[i],++count);
            }else{
                map.put(arr1[i],1);
            }
        }
//        HashMap<Character,Integer> map2 = new HashMap<>();
//        for(int j = 0;j < arr1.length;j++){
//            if(map2.containsKey(arr2[j])){
//                int count = map2.get(arr2[j]);
//                map2.replace(arr2[j],++count);
//            }else{
//                map2.put(arr2[j],1);
//            }
//        }
        int none = 0;
        for(int j = 0;j < arr2.length;j++){
            if(map.containsKey(arr2[j])){
                int count = map.get(arr2[j]);
                if(count <= 0){
                    none++;
                }
                map.replace(arr2[j],--count);
            }else{
                none++;
            }
        }
        if(none == 0){
            System.out.print("YES ");
            int remain = sell.length()-want.length();
            System.out.print(remain);
        }else{
            System.out.print("No "+none);
        }
    }
}
