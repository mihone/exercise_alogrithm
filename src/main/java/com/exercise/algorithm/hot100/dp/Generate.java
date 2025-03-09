package com.exercise.algorithm.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
*  @author mihone
*  @since 2025/3/9 14:51
*/
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        ret.get(0).add(1);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j==i-1) {
                    row.add(1);
                }
                else {
                    row.add(ret.get(i - 2).get(j - 1) + ret.get(i - 2).get(j));
                }

            }
            ret.add(row);
        }
        return ret;

    }
}
