package com.exercise.algorithm.hot100.v1.backtrack;

/**
 * 79. 单词搜索
 *
 * @author mihone
 * @since 2025/3/4 20:49
 */
public class Exist {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean b = internal(board, i, j, 0,word, visited, dest);
                if (b) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean internal(char[][] board, int i, int j, int cur,String word, boolean[][] visited, int[][] dest) {
        if (cur == word.length()) {
            return true;
        }
        if (i<0 || j<0 || i>=board.length|| j>=board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(cur)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] d : dest) {
            int r =  d[0];
            int c =  d[1];
            boolean b = internal(board, i + c, j + r, cur + 1, word, visited, dest);
            if (b) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;

    }
}
