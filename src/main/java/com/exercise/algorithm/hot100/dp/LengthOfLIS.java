package com.exercise.algorithm.hot100.dp;
/**
 * [REPEAT]
 * 300. 最长递增子序列
*  @author mihone
*  @since 2025/3/12 20:23
*/
public class LengthOfLIS {

    public static void main(String[] args) {

    }
    //o(n2)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //以第 i 个数字结尾的最长上升子序列 的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;


    }


    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                //找到第一个比nums[i] 大的数，替换它=====二分法找插入位置
                int l = 1, r = len; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) /2;
                    if (d[mid] == nums[i]) {
                        l = mid;
                        break;
                    }
                    if (d[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[l] = nums[i];
            }
        }
        return len;
    }
}
