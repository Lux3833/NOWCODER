package Other.TeacherZuo;
import java.util.ArrayList;
import java.util.List;
/**
 * @title: Test1
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 3:35
 * @Description:
 * 打印一个字符串的全部子序列
 */
public class Test1 {
    public static void main(String args[]){
        Utils utils = new Utils();
        String str = utils.inputStr();
        List<String> list = new ArrayList<>();
        allSubSquences(str.toCharArray(),list,0,"");
        System.out.println(list);
    }

    private static void allSubSquences(char[] ch, List<String> list, int index, String path) {
        if(index == ch.length){
            list.add(path);
            return;
        }
        String yes = path + String.valueOf(ch[index]);
        allSubSquences(ch, list, index+1, yes);
        String no = path;
        allSubSquences(ch, list, index+1, no);
    }
}
