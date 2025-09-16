package com.exercise.algorithm.lcr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LCR 075. 数组的相对排序
*  @author mihone
*  @since 2025/9/16 21:33
*/
public class LCR075 {

    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : arr1) {
            Integer i1 = map.get(i);
            if (i1 == null) {
                map.put(i,1);
            }else {
                map.put(i,i1+1);
            }
        }
        int[] ret = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            Integer count = map.get(i);
            for (int j = 0; j < count; j++) {
                ret[index++] = i;
            }
            map.remove(i);
        }
        int sort = index;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                ret[index++] = entry.getKey();
            }
        }
        Arrays.sort(ret, sort, ret.length);
        return ret;

    }
}
