package LeetCode.Test61_120;

import LeetCode.Utils;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @title: Test71
 * @Author: Lux_er
 * @Date: 2021/5/16 0016 上午 9:49
 * @Description:简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，
 * 任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * 示例：
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 */
public class Test71 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        String str = utils.inputStr();
        System.out.println(simplifyPath(str));
    }
    public static String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();//用栈来模拟
        String[] strArr = path.split("/");//用/分割，多个/也视为/
        for(String str: strArr){//遍历
            //如果等于空或者等于.，那就没有影响
            if(str.equals("") || str.equals(".")){
                continue;
            }
            //如果等于..，那就要返回上一级目录，因此栈中弹出当前目录
            //此时可能栈是空
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            //否则，栈中压入当前目录
            stack.push(str);
        }
        StringBuffer sb = new StringBuffer();
        Collections.reverse(stack);
        while(!stack.isEmpty()){
            String tmp = stack.pop();
            sb.append("/").append(tmp);
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        String res = sb.toString();
        return res;
    }
}
