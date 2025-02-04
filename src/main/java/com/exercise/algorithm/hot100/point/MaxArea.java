package com.exercise.algorithm.hot100.point;

/**
 * 11. 盛最多水的容器
 *
 * @author mihone
 * @since 2025/2/3 11:38
 */
public class MaxArea {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
