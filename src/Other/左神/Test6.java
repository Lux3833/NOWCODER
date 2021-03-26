package Other.左神;
/**
 * @title: Test6
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 下午 5:46
 * @Description:
 * 给定一个整型数组arr,代表数值不同的纸牌排成一条线，
 * 玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明，请返回最后获胜者的分数。
 */
public class Test6 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int res = win(nums);
        System.out.println(res);
    }

    private static int win(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return Math.max(f(nums,0,nums.length-1), s(nums,0,nums.length-1));
    }
    private static int f(int[] nums, int L, int R) {
        if(L == R){
            return nums[L];
        }
        return Math.max(nums[L]+s(nums,L+1, R),
                nums[R]+s(nums,L,R-1));
    }
    private static int s(int[] nums, int L, int R) {
        if(L == R){
            return 0;
        }
        return Math.min(f(nums,L+1,R),f(nums, L,R-1));
    }
}
