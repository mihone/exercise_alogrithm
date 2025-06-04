package com.exercise.algorithm.hot100.v2.point;
/**
*  @author mihone
*  @since 2025/5/28 15:47
*/
public class MaxArea {


    public int maxArea(int[] height) {
        if (height.length <=1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
// 1 2 3 4 5
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}
