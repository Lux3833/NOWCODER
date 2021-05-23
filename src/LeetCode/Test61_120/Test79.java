package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test79
 * @Author: Lux_er
 * @Date: 2021/5/18 0018 上午 10:06
 * @Description:单词搜索
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Test79 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int m = utils.inputNumber();
        int n = utils.inputNumber();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = utils.inputCharacter();
            }
        }
        String word = utils.inputStr();
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, 0, i, j, word)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int index, int i, int j,String word) {
        if(index == word.length()){
            return true;
        }
        if(i > board.length-1 || j > board[0].length-1 || i < 0 || j < 0){
            return false;
        }
        if(board[i][j] == word.charAt(index)) {
            index++;
        }else{
            return false;
        }
        boolean res = false;
        char t = board[i][j];
        board[i][j] = '0';
        res = dfs(board, index, i, j+1, word)|| dfs(board,index, i+1, j, word)||
              dfs(board,index,i-1,j,word)|| dfs(board,index,i,j-1,word);
        board[i][j] = t;
        return res;
    }
}
