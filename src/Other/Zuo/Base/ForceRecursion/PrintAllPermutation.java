package Other.Zuo.Base.ForceRecursion;

import java.util.ArrayList;

/**
 * @title: PrintAllPermutation
 * @Author: Lux_er
 * @Date: 2021/4/23 0023 下午 12:12
 * @Description:全排列
 * 打印全排列
 * 打印不重复的全排列
 */
public class PrintAllPermutation {
    public static ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        res.sort(null);
        return res;
    }

    private static void process(char[] chs, int i, ArrayList<String> res) {
        if(i == chs.length){
            res.add(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs,i,j);
            process(chs,i+1,res);
            swap(chs,i,j);
        }
    }
    // 不重复添加
    private static void process2(char[] chs, int i, ArrayList<String> res) {
        if(i == chs.length){
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if(!visit[chs[j]-'a']){
                visit[chs[j]-'a'] = true;
                swap(chs,i,j);
                process(chs,i+1,res);
                swap(chs,i,j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> list = Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
