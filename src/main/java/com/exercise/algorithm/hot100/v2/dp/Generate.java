package com.exercise.algorithm.hot100.v2.dp;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) {
                   part.add(1);
                } else {
                    int left = ret.get(ret.size() - 1).get(j - 1);
                    int right = ret.get(ret.size() - 1).get(j);
                    part.add(left + right);
                }
            }
            ret.add(part);
        }
        return ret;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> result = generate.generate(5);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
