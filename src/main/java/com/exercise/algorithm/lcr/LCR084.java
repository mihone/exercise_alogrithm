package com.exercise.algorithm.lcr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 084. 全排列 II
*  @author mihone
*  @since 2025/9/23 21:08
*/
public class LCR084 {
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //从左到右依次填
            //如果填过，那么跳过
            //如果没填过，但是当前的数字和前一个一样
                // 假如前一个填了，说明是按顺序填充的，继续往下填
                // 如果前一个没填，说明前一个数字已经遍历完了，再遍历自己这个相同数据会产生问题
                // 所以要过滤
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
