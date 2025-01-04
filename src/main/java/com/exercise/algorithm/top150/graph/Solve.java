package com.exercise.algorithm.top150.graph;
/**
 *
 * [REPEAT]
 * 130. 被围绕的区域
*  @author mihone
*  @since 2025/1/4 16:59
*/
public class Solve {

    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] flag=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0 || i==m-1||j==n-1){
                    if (board[i][j]=='O'){
                        dfs(board,i,j,flag);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
        return;
    }
    public void dfs(char[][] board,int i, int j,boolean[][] flag){
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || flag[i][j]==true || board[i][j]=='X'){
            return;
        }
        flag[i][j]=true;
        dfs(board,i+1,j,flag);
        dfs(board,i-1,j,flag);
        dfs(board,i,j+1,flag);
        dfs(board,i,j-1,flag);
    }
}
