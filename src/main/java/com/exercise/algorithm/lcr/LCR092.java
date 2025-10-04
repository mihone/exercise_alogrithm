package com.exercise.algorithm.lcr;
/**
 * LCR 092. 将字符串翻转到单调递增
 * [REPEAT]
*  @author mihone
*  @since 2025/10/2 11:37
*/
public class LCR092 {

    public int minFlipsMonoIncr(String s) {
        /**
         *
         * 假设字符串 s 的长度是 n，对于 0≤i<n，用 dp[i][0] 和 dp[i][1]
         * 分别表示下标 i 处的字符为 0 和 1 的情况下使得 s[0..i] 单调递增的最小翻转次数。
         *
         * */
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当下标是0时，只有前一个也是0才符合单调递增
            int dp0New = dp0;
            // 当下标识1 时，前一个0或者1 都符合，所以要取一个最小的
            int dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

}
