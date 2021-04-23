package Other.Zuo.Base.ForceRecursion;

/**
 * @title: Hanoi
 * @Author: Lux_er
 * @Date: 2021/4/23 0023 上午 11:38
 * @Description:汉诺塔
 */
public class Hanoi {
    public static void hanoi(int n){
        if(n > 0){
            func(n,"左","右","中");
        }
    }

    private static void func(int i, String start, String end, String other) {
        if(i == 1){
            System.out.println("Move 1 from "+start+" to "+end);
        }else{
            // 1 ~ i-1 从start挪到other上
            func(i-1, start, other, end);
            // 将i挪到end上
            System.out.println("Move "+i+" from "+start+" to "+end);
            // 1 ~ i-1 从other挪到end上
            func(i-1,other, end, start);
        }
    }
    public static void main(String[] args){
        int n = 4;
        hanoi(n);
    }
}
