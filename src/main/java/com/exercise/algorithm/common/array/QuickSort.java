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
            while (left <= end && nums[left] >= pVal) {
                left++;
            }

            while (right >= start && nums[right] < pVal) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        // 将基准数放到正确的位置
        int temp = nums[left - 1];
        nums[left - 1] = nums[start];
        nums[start] = temp;

        qs(nums, start, left - 1);
        qs(nums, left, end);

        return left;
    }

    public static void qsSearch(int[] nums) {
        qs2(nums, 0, nums.length - 1);

    }
    /*
    * 快排中为什么一定是右边先开始循环？
从右边先开始的前提是我们选择序列中最左边的元素最为基准值。
先从右边开始可以保证i,j相等的时候，arr[i] = arr[j] 小于基准值p。这样交换之后才能保证基准值左右两边分别小于和大于它的值。
    *
    * */
    public static void qs2(int[] nums,int start,int end){
        // 方法退出条件,指针相遇或低位大于高位指针
        if (start >= end) {
            return;
        }
        Random random = new Random();
        int ra = random.nextInt(end - start + 1);
        int pivot = start + ra;
        int pVal = nums[pivot];
        nums[pivot] = nums[start];
        nums[start] = pVal;
        // 首先指定基准位和左右指针记录位置

        int l = start;
        int r = end;
        int temp = 0;
        // 左指针小于右指针则进行遍历
        while (l < r) {
            // 先进行右边遍历
            while (l < r && nums[r] <= pVal) {
                r--;
            }
            // 左边遍历
            while (l < r && nums[l] >= pVal) {
                l++;
            }
            if (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        // 当左右指针相遇，则交换基准位的位置
        nums[start] = nums[l];
        nums[l] = pVal;
        // 再根据条件进行左边递归遍历
//        if (start < l) {
            qs2(nums, start, l - 1);
//        }
        // 根据条件右边进行递归遍历
//        if (r < end) {
            qs2(nums, r + 1, end);
//        }
    }


}
