package com.exercise.algorithm.common.array;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //核心代码---开始
    private static int partition(int[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = arr[l];
        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] > v)
                i++;
            while (j >= l + 1 && arr[j] < v)
                j--;
            if (i > j)
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }
    //核心代码---结束

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        int[] ints = {6, 5, 3, 4, 1, 4, 5, 2};
//        sort(ints);
        qsSearch(ints);
        System.out.println(Arrays.toString(ints));
    }

    //todo
    public static int qs(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int left = start;
        int right = end;
        Random random = new Random();
        int r = random.nextInt(right - left + 1);
        int pivot = left + r;
        int pVal = nums[pivot];
        nums[pivot] = nums[left];
        nums[left] = pVal;

        while (left < right) {
            while (left < right && nums[left] >= pVal) {
                left++;
            }

            while (left < right && nums[right] < pVal) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        // 将基准数放到正确的位置
        int temp = nums[left-1];
        nums[left-1] = nums[start];
        nums[start] = temp;

        qs(nums, start, left - 1);
        qs(nums, left, end);

        return left;
    }

    public static void qsSearch(int[] nums) {
        qs(nums, 0, nums.length - 1);

    }


}
