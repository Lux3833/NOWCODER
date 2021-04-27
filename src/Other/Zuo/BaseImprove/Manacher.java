package Other.Zuo.BaseImprove;

/**
 * @title: Manacher
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 4:15
 * @Description:解决字符串中,最长回文子串的长度
 */
public class Manacher {
    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[charArr.length * 2 - 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = manacherString(s);
        // 回文半径数组
        int[] pArr = new int[str.length];
        // 中心
        int C = -1;
        // 回文右边界再往右一个位置,最右的有效区是R-1
        int R = -1;
        int max = Integer.MIN_VALUE;
        // 每个位置都求回文半径
        for (int i = 0; i != str.length; i++) {
            // i至少的回文区域,先给pArr[i]
            // i在R外,回文半径为1,否则是i在R内的情况;2*C-i是i`的位置
            pArr[i] = R > i ? Math.min(pArr[2*C - i],R - i) : 1;
            while(i + pArr[i] < str.length && i - pArr[i] > -1){
                if(str[i +pArr[i]] == str[i - pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > R){
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        // 原始回文串长度要减一
        return max-1;
    }
}
