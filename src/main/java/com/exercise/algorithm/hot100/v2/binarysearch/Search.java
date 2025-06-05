package com.exercise.algorithm.hot100.v2.binarysearch;
/**
 * [ENHANCE] 注意边界
*  @author mihone
*  @since 2025/6/5 15:28
*/
public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{1, 3}, 3));

    }

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[mid] < target) {
                    left = left + 1;
                } else {
                    if (target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

            } else {
                if (nums[mid] < target) {
                    if (target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;

                }
            }

        }

        return -1;

    }
}
