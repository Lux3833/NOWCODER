package LeetCode;

import java.util.*;

/**
 * @title: Test17
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:04
 * @Description:
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Test17 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String str = utils.inputStr();
        List<String> list = new ArrayList<>();
        list = letterCombinations(str);
        System.out.println(list);
    }

    private static List<String> letterCombinations(String str) {
        List<String> list = new ArrayList<>();
        if(str == null || str.length() == 0){
            return list;
        }
        //将号码字母对应关系存储进Map
        HashMap<Character,String[]> map = new HashMap<>();
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
        //根据数字个数逐个拼接字母
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            queueCombinations(queue,map.get(str.charAt(i)));
        }
        for (String s : queue) {
            list.add(s);
        }
        return list;
    }

    private static void queueCombinations(Queue<String> queue, String[] strings) {
        if(queue.size() == 0){
            for (String string : strings) {
                queue.add(string);
            }
        }else{
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String head = queue.poll();//取出队列头元素
                for (int j = 0; j < strings.length; j++) {
                    queue.add(head+strings[j]);
                }
            }
        }
    }
}
