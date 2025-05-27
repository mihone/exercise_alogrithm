package com.exercise.algorithm.hot100.v1.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * [REPEAT]
 * 763. 划分字母区间
*  @author mihone
*  @since 2025/3/10 21:17
*/
public class PartitionLabels {
    public static void main(String[] args) {

    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
