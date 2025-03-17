package com.exercise.algorithm.dash2024.matrix;

/**
 * 289. 生命游戏
 *
 * @author mihone
 * @since 2025/3/17 21:47
 */
public class GameOfLife {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int[][] dest = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                int dead = 0;
                for (int[] d : dest) {
                    int ii = i + d[0];
                    int jj = j + d[1];
                    if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length) {
                        //活着或者即将死去
                        if (board[ii][jj] == 1 || board[ii][jj] == 2) {
                            live++;
                        } else {
                            dead++;
                        }
                    }
                }
                if (board[i][j] == 1 || board[i][j] == 2) {
                    if (live > 3 || live < 2) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 1;
                    }

                } else if (board[i][j] == 0 || board[i][j] == 3) {
                    if (live == 3) {
                        board[i][j] = 3;
                    }

                }

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (board[i][i1] ==2) {
                    board[i][i1] = 0;
                }
                if (board[i][i1] ==3) {
                    board[i][i1] = 1;
                }
            }
        }

    }
}
