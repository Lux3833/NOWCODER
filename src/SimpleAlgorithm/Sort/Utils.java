package SimpleAlgorithm.Sort;
import java.util.Scanner;
/**
 * @title: InputNums
 * @Author: Lux_er
 * @Date: 2021/3/11 0011 下午 6:57
 * @Description:
 * 提供键盘输入数组的公共方法
 */
class Utils {
    //输入整数进数组，返回数组
    public int[] inputNums(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }
    //打印整型数组
    public void showNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
