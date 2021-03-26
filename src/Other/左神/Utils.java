package Other.左神;
import java.util.Scanner;
/**
 * @title: InputNums
 * @Author: Lux_er
 * @Date: 2021/3/11 0011 下午 6:57
 * @Description:
 * 提供公共方法
 */
class Utils {
    public int[] inputNums(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }
    public int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }
    public String inputStr(){
        Scanner scanner = new Scanner(System.in);
        return  scanner.next();
    }
    public void printNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
