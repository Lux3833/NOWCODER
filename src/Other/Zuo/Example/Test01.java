package Other.Zuo.Example;

/**
 * @title: Test01
 * @Author: Lux_er
 * @Date: 2021/5/4 0004 上午 11:34
 * @Description:
 * 给定一个只由小写字母组成的字符串str
 * 返回其中最长无重复字符的子串长度
 */
public class Test01 {
    public static int lnrs(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        // last[0] -> a上次出现的位置
        // last[1] -> b上次出现的位置 ...
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        last[str[0] - 'a'] = 0;
        int max = 1;
        // i-1位置的无重复子串长度
        int preMaxLen = 1;
        for (int i = 0; i < N; i++) {
          preMaxLen = Math.min(i-last[str[i]-'a'],preMaxLen+1);
          max = Math.max(max,preMaxLen);
          // 更新当前字符上一次出现的位置
          last[str[i] - 'a'] = i;
        }
        return max;
    }
}
