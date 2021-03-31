package Other.TeacherZuo;
import java.util.ArrayList;
import java.util.List;
/**
 * @title: Test3
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 4:14
 * @Description:
 * 打印一个字符串的全部排列,要求结果没有重复序列
 */
public class Test3 {
    public static void main(String args[]){
        Utils utils = new Utils();
        String str = utils.inputStr();
        List<String> list = new ArrayList<>();
        allPermuta(str.toCharArray(),list,0);
        System.out.println(list);
    }

    private static void allPermuta(char[] ch, List<String> list, int index) {
        if(index == ch.length){
            list.add(String.valueOf(ch));
        }
        boolean[] visit = new boolean[26];//代表a-z的字符是否被使用过
        for (int i = index; i < ch.length; i++) {
            if(!visit[ch[i] - 'a']){
                visit[ch[i] - 'a'] = true;
                swap(ch,i,index);
                allPermuta(ch, list, index+1);
                swap(ch,i,index);
            }
        }
    }
    private static void swap(char[] ch,int i,int j){
        char temp = '0';
        temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
