package com.exercise.algorithm.top150.binarysearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author mihone
 * @since 2025/1/19 10:51
 */
public class FindMin {

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{2,1}));
    }

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (isMin(nums, mid, mid - 1, mid + 1)) {
                return nums[mid];
            }
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    private boolean isMin(int[] nums, int midIndex, int lIndex, int rIndex) {
        if (lIndex < 0 ) {
            return nums[midIndex] < nums[rIndex];
        }
        if (rIndex >= nums.length) {
            return nums[midIndex] < nums[lIndex];
        }
        return nums[midIndex] < nums[lIndex] && nums[midIndex] < nums[rIndex];

    }

}
