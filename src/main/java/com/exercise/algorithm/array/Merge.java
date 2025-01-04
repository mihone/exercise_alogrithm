package com.exercise.algorithm.array;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author mihone
 * @since 2024/11/19 8:07
 */
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] r = {1, 2, 3, 0, 0, 0};
        int[] r2 = { 0};
        merge.merge(r2,0,new int[]{2},1);
        System.out.println(Arrays.toString(r));


    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int mi = m - 1;
        int ni = n - 1;
        while (mi >= 0 && ni >= 0) {
            if (nums1[mi] >= nums2[ni]) {
                nums1[index] = nums1[mi];
                nums1[mi] = 0;
                mi--;
            } else {
                nums1[index] = nums2[ni];
                nums2[ni] = 0;
                ni--;
            }
            index--;
        }
        if (mi>=0) {
            while (mi>=0){
                nums1[index--] = nums1[mi--];
            }
        }else {
            while (ni>=0){
                nums1[index--] = nums2[ni--];
            }
        }

    }

}
