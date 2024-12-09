package com.exercise.algorithm.top150.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
*  @author mihone
*  @since 2024/12/7 16:47
*/
public class IsValidSudoku {

    public static void main(String[] args) {


    }

    public boolean isValidSudoku(char[][] board) {
        int colLength = board[0].length;
        int rowLength = board.length;
        Set<Character> set = new HashSet<>();
        //横排
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar!='.') {
                    if (!set.add(aChar)) {
                        return false;
                    }
                }
            }
            set.clear();
        }

        //竖排

        for (int i = 0; i < colLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (board[j][i]!='.') {
                    if (!set.add(board[j][i])) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        //3*3

        for (int cs = 0; cs < colLength; cs = cs +3) {
            for (int rs = 0; rs < rowLength; rs = rs +3) {
                boolean b = valid33(board, cs, rs, set);
                if (!b) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean valid33(char[][] board,int c,int r,Set<Character> set) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c+3; j++) {
                if (board[i][j]!='.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        set.clear();
        return true;

    }
}
