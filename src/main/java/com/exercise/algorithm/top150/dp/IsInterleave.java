package com.exercise.algorithm.top150.dp;

/**
 * [REPEAT]
 * 97. 交错字符串
 *
 * @author mihone
 * @since 2025/1/25 10:08
 */
public class IsInterleave {

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        boolean interleave2 = isInterleave.isInterleave2("aabcc", "dbbca", "aadbbcbcac");
        System.out.println();
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            f[i][0] = f[i - 1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= m; i++) {
            f[0][i] = f[0][i - 1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                int p = i + j-1;
                f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i-1) == s3.charAt(p)) || (f[i][j - 1] && s2.charAt(j-1) == s3.charAt(p));
            }
        }
        return f[n][m];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }


}
