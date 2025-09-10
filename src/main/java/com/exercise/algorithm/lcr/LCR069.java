package com.exercise.algorithm.lcr;

/**
 * LCR 069. 山脉数组的峰顶索引
 *
 * @author mihone
 * @since 2025/9/10 21:52
 */
public class LCR069 {


    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int minM = mid - 1 < 0 ? -1 : arr[mid - 1];
            int minP = mid + 1 > arr.length - 1 ? -1 : arr[mid + 1];
            if (arr[mid] > minM && arr[mid] > minP) {
                return mid;
            }
            //说明山顶在右边
            if (arr[mid] > minM && arr[mid] < minP) {
                left = mid + 1;
            }
            //说明山顶在左边
            if (arr[mid] < minM && arr[mid] > minP) {
                right = mid - 1;
            }
        }
        return left;

    }
}
