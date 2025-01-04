package com.exercise.algorithm.top150.point;
/**
 *
 * 11. 盛最多水的容器
*  @author mihone
*  @since 2024/12/3 8:28
*/
public class MaxArea {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        int x = 0;
        int max = 0;
        int y = height.length - 1;
        while (x<y){
            int area = (y - x) * Math.min(height[x], height[y]);
            max = Math.max(max, area);
            if (height[x]>height[y]) {
                y--;
            }else {
                x++;
            }
        }
        return max;

    }
}
