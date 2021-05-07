package Other.Zuo.Example;

import java.util.HashSet;

/**
 * @title: Test02
 * @Author: Lux_er
 * @Date: 2021/5/7 0007 上午 9:19
 * @Description:
 * 如果两个字符串，所含字符种类完全一样，就算做一类
 * 只由小写字母组成的一批字符串
 * 都放在字符类型的数组String[] arr中，返回arr中一共有多少类？
 */
public class Test02 {
    public static int type1(String[] arr){
        HashSet<String> types = new HashSet<>();
        for (String str : arr) {
            char[] chs = str.toCharArray();
            boolean[] map = new boolean[26];
            for (int i = 0; i < chs.length; i++) {
                map[chs[i] - 'a'] = true;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(map[i]){
                    key.append(String.valueOf((char)(i+'a')));
                }
                types.add(key.toString());
            }
        }
        return types.size();
    }
    // 更好的方法,时间复杂度没有变化，但是常数级别的会提高速度
    public static int type2(String[] arr){
        // 每个整数值代表一个摘要
        HashSet<Integer> types = new HashSet<>();
        for (String str : arr) {
            char[] chs = str.toCharArray();
            int key = 0;
            for (int i = 0; i < chs.length; i++) {
                key |= (1 << (chs[i] - 'a'));
            }
            types.add(key);
        }
        return types.size();
    }
}
