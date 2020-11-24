package LeetCode;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/24 - 20:25
 * @Description:
 * 4. 寻找两个正序数组的中位数给定两个大小为 m 和 n 的正序
 * （从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 *
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 *
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] num1 = new int[m];
        for(int i = 0;i < m;i++){
            num1[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int[] num2 = new int[n];
        for(int j = 0;j < n;j++){
            num2[j] = scanner.nextInt();
        }
        scanner.close();
        double res = findMedianSortedArrays(num1,num2);
        System.out.println(res);
    }

    private static double findMedianSortedArrays(int[] num1, int[] num2) {
        double res = 0.0;
        int len1 = num1.length;
        int len2 = num2.length;
        int len3 = len1+len2;
        int i = 0;
        int j = 0;
        int index = 0;
        int[] num3 = new int[len3];
        while(i < len1 && j < len2){
            if(num1[i] < num2[j]){
                num3[index] = num1[i];
                index++;
                i++;
            }else {
                num3[index] = num2[j];
                index++;
                j++;
            }
        }
        if(i < len1){
            while(i != len1){
                num3[index] = num1[i];
                index++;
                i++;
            }
        }
        if(j < len2){
            while(j != len2){
                num3[index] = num2[j];
                index++;
                j++;
            }
        }
        if(len3 % 2 == 0){
            res = (num3[len3/2]+num3[len3/2-1])/2.0;
        }else{
            res = num3[len3/2];
        }
        return res;
    }
}
