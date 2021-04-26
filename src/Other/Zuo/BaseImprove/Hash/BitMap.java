package Other.Zuo.BaseImprove.Hash;

/**
 * @title: BitMap
 * @Author: Lux_er
 * @Date: 2021/4/25 0025 下午 2:27
 * @Description:布隆过滤器,只有加入和查询操作,且允许一定范围内的错误率,错误只包含白名单->黑名单
 * n:样本量
 * p:失误率
 * 注:单样本大小无关
 */
public class BitMap {
    public static void main(String[] args) {
        int a = 0;
        int[] arr = new int[10];// 32bit * 10 -> 320bits

        int i = 178;// 想查询178个bit的状态
        int numIndex = 178 / 32;// 信息在哪个数上找
        int bitIndex = 178 % 32;// 信息在数的哪个位上找
        // 拿到178位的状态
        int s = ((arr[numIndex] >> (bitIndex)) & 1);

        i = 178;
        // 把178位的状态改成1
        arr[numIndex] = arr[numIndex] | (1 << (bitIndex));

        i = 178;
        // 把178位的状态改成0
        arr[numIndex] = arr[numIndex] & (~ (1 << (bitIndex)));
    }
}
