package com.exercise.algorithm.top150.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 77. 组合
 *
 * @author mihone
 * @since 2025/1/13 21:20
 */
public class Combine {


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ret = new ArrayList<>();
        back(n, k,1, new HashSet<>(), ret);
        return ret;
    }

    public void back(int n, int k,int start, Set<Integer> part, List<List<Integer>> ret) {
        if (part.size() == k) {
            ret.add(new ArrayList<Integer>(part));
            return;
        }
        for (int i = start; i <= n; i++) {
            part.add(i);
            back(n, k,i+1 ,part, ret);
            part.remove(i);
        }
    }
}
