package Other.左神;
import java.util.ArrayList;
import java.util.List;
/**
 * @title: Test2
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 3:50
 * @Description:
 * 打印一个字符串的全部排列
 */
public class Test2 {
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
        for (int i = index; i < ch.length; i++) {
            swap(ch,i,index);
            allPermuta(ch, list, index+1);
            swap(ch,i,index);
        }
    }
    private static void swap(char[] ch,int i,int j){
        char temp = '0';
        temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
