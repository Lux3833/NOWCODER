package LeetCode;

import java.util.*;

/**
 * @title: Test49
 * @Author: Lux_er
 * @Date: 2021/3/30 0030 上午 9:36
 * @Description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，
 * 但排列不同的字符串。
 */
public class Test49 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String[] strs = utils.inputStrs();
        List<List<String>> lists = new ArrayList<>();
        lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
