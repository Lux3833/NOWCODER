package Other.Zuo.BaseImprove;

/**
 * @title: KMP
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 1:36
 * @Description:KMP
 * 字符串str1和str2,str1是否包含str2,如果包含返回str2在str1中开始的位置
 */
public class KMP {
    // N >= M
    public static int KMP(String s,String m){
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);// O(M)
        // O(N)
        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        // i1越界 或者 i2越界
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] ms) {
        if(ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < next.length){
            if(ms[i-1] == ms[cn]){
                next[i++] = ++cn;
            }
            //当前跳到cn的字符,和i-1位置的字符配不上
            else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
