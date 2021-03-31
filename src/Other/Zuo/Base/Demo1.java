package Other.Zuo.Base;

/**
 * @title: Demo1
 * @Author: Lux_er
 * @Date: 2021/3/30 0030 上午 11:19
 * @Description:
 * 给定一个数组，里面仅有两个数是重复出现一次的，打印这两个数
 */
public class Demo1 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int eor = 0;
        for (int i = 0; i < nums.length; i++) {
            eor ^= nums[i];
        }
        int rightOne = eor & (~eor + 1);//提取最右侧的1
        int onlyOne = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                onlyOne ^= num;
            }
        }
        System.out.println(onlyOne+" "+(eor ^ onlyOne));
    }
}
