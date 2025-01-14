package com.exercise.algorithm.top150.backtrack;

/**
 * [ENHANCED]
 * 79. 单词搜索
 *
 * @author mihone
 * @since 2025/1/13 21:52
 */
public class Exist {

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));

    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] dest = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean back = back(board, word, 0, visited, dest, i, j);
                    if (back) {
                        return true;
                    }
                }

            }
        }
        return false;


    }

    public boolean back(char[][] board, String word, int cur,
                        boolean[][] visited, int[][] dest,
                        int r, int c) {
        if (cur == word.length()) {
            return true;
        }
        if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || visited[r][c]) {
            return false;
        }
        char ch = word.charAt(cur);
        if (board[r][c] != ch) {
            return false;
        }


        for (int[] d : dest) {
            int i = d[0];
            int j = d[1];
            visited[r][c] = true;
            boolean back = back(board, word, cur + 1, visited, dest, r + i, c + j);
            if (back) {
                return true;
            }
            visited[r][c] = false;
        }
        return false;
    }
}
