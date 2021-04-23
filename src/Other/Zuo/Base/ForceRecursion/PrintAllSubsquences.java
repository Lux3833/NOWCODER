package Other.Zuo.Base.ForceRecursion;

import java.util.ArrayList;

/**
 * @title: PrintAllSubsquences
 * @Author: Lux_er
 * @Date: 2021/4/23 0023 上午 11:54
 * @Description:
 */
public class PrintAllSubsquences {
    public static void function(String str){
        char[] chs = str.toCharArray();
        process(chs,0,new ArrayList<Character>());
    }

    private static void process(char[] str, int i, ArrayList<Character> res) {
        if(i == str.length){
            printList(res);
            return;
        }
        ArrayList<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str,i+1,resKeep);
        ArrayList<Character> resNoInclude = copyList(res);
        process(str,i+1,resNoInclude);
    }

    private static ArrayList<Character> copyList(ArrayList<Character> res) {
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }

    private static void printList(ArrayList<Character> res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "abc";
        function(str);
    }
}
