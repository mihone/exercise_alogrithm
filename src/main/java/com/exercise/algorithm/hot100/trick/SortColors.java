package com.exercise.algorithm.hot100.trick;
/**
 * [ENHANCE]
 * 75. 颜色分类
*  @author mihone
*  @since 2025/3/16 16:25
*/
public class SortColors {

    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int index = 0;
        int nBlue = nums.length-1;
        int nRed = 0;

        while (index <= nBlue) {
            if (nums[index] ==2) {
                int temp = nums[index];
                nums[index] = nums[nBlue];
                nums[nBlue] = temp;
                nBlue--;
                continue;
            }
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[nRed];
                nums[nRed] = temp;
                nRed++;
            }
            index++;
        }

    }
}
