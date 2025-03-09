package com.exercise.algorithm.hot100.binary;
/**
 * 153. 寻找旋转排序数组中的最小值
*  @author mihone
*  @since 2025/3/9 11:04
*/
public class FindMin {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid =  (right + left) / 2;
//            if (nums[mid] > nums[mid+1]) {
//                return nums[mid];
//            }
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }

        }
        return nums[right];


    }
}
