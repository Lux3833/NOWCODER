package Other.TeacherZuo;
/**
 * @title: Test4
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 4:21
 * @Description:
 * 规定1和A对应，2和B对应，3和C对应...
 * 那么一个数字字符串比如“111”就可以转化为：
 * “AAA”，“KA”和“AK”
 * 给定一个只有数字字符组成的字符串str,返回有多少种转化结果
 */
public class Test4 {
    public static void main(String args[]){
        Utils utils = new Utils();
        String str = utils.inputStr();
        int res = process(str.toCharArray(),0);
        System.out.println(res);
    }

    private static int process(char[] str, int index) {
        if(index == str.length){
            return 1;
        }
        //index没有到达终止位置
        if(str[index] == '0'){
            return 0;
        }
        //str[index]字符不是'0'
        if(str[index] == '1'){
            //index作为自己单独的部分，后续有多少种方法
            int res = process(str, index+1);
            if(index+1 < str.length){
                //index和index+1作为单独的部分，后续有多少种方法
                res += process(str,index+2);
            }
            return res;
        }
        if(str[index] == '2'){
            //index作为自己单独的部分，后续有多少种方法
            int res = process(str, index+1);
            if(index+1 < str.length && (str[index+1] >= '0' && str[index+1] <= '6')){
                //index和index+1作为单独的部分，后续有多少种方法
                res += process(str,index+2);
            }
            return res;
        }
        //str[index] == '3'~'9'
        return process(str,index+1);
    }
}
