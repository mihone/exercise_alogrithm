package com.exercise.algorithm.hot100.v2.backtrack;

/**
 * [ENHANCE]
 * @author mihone
 * @since 2025/6/5 14:12
 */
public class Exist {

    public static void main(String[] args) {
        Exist exist = new Exist();
        boolean aab = exist.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB");
        System.out.println(aab);
    }

    int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, visit, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public boolean exist(char[][] board, String word,
                         boolean[][] visit, int cur,
                         int i, int j) {

        if (cur == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                visit[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(cur)) {
            return false;
        }
        visit[i][j] = true;
        boolean ret = false;
        for (int[] d : dest) {
            int newi = i + d[0];
            int newj = j + d[1];
            ret = ret || exist(board, word, visit, cur + 1, newi, newj);
        }
        visit[i][j] = false;
        return ret;
    }
}
