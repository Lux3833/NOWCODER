package LeetCode;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @title: Test36
 * @Author: Lux_er
 * @Date: 2021/3/19 0019 上午 10:48
 * @Description:
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，
 * 验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *
 */
public class Test36 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        char[][] arr = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scanner.next().charAt(0);
            }
        }
        boolean res = isValidSudoku(arr);
        System.out.println(res);
    }

    private static boolean isValidSudoku(char[][] arr) {
        HashMap<Integer,Integer> [] rows = new HashMap[9];
        HashMap<Integer,Integer> [] cols = new HashMap[9];
        HashMap<Integer,Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = arr[i][j];
                if(num != '.'){
                    int n = (int)num;
                    int box_index = (i / 3) * 3 + j / 3;//很重要

                    rows[i].put(n, rows[i].getOrDefault(n, 0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);

                    if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[box_index].get(n) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
