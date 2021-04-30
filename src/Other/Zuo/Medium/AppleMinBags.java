package Other.Zuo.Medium;

/**
 * @title: AppleMinBags
 * @Author: Lux_er
 * @Date: 2021/4/28 0028 下午 2:33
 * @Description:
 * 小明买苹果,超市只提供6个每袋和8个每袋的袋子,且袋子只能正好装这些数量,
 * 不可以增加或者减少.要求尽可能少的使用袋子来购买想要的苹果.如果无论如何
 * 都无法正好装下,则返回-1
 */
public class AppleMinBags {
    // 普通解法
    public static int minBags(int apple){
        if(apple < 0){
            return -1;
        }
        int bag6 = -1;
        int bag8 = -1;
        int rest = apple - 8 * bag8;
        // 注意:如果装8个苹果的袋子用后,剩余的苹果数超过24,则一定不可以正好装下
        while(bag8 >= 0 && rest < 24){
            int restUse6 = minBagBase6(rest);
            if(restUse6 != -1){
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6+bag8;
    }
    // 剩余苹果能否被6整除,可以返回袋子数量,否则返回-1
    private static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }
}
