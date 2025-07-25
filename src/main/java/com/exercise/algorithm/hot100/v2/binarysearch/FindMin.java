package com.exercise.algorithm.hot100.v2.binarysearch;
/**
 * [REPEAT]
 * 完全不会
*  @author xinyux
*  @since 2025/6/5 20:10
*/
public class FindMin {



    //求最小值
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];

    }

// 为什么要跟右边比？Eileen可以无限逼近最小值。
    //为什么循环条件没有等于，因为循环内部不需要处理等于的场景。
    //求最小值
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];

    }
}
