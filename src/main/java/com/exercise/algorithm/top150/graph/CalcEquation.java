package com.exercise.algorithm.top150.graph;

import java.util.*;

/**
 * [REPEAT]
 * 399. 除法求值
 *
 * @author mihone
 * @since 2025/1/4 19:07
 */
public class CalcEquation {

    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String k1 = equation.get(0);
            String k2 = equation.get(1);
            double value = values[i];
            equationMap.computeIfAbsent(k1, k -> new HashMap<>()).put(k2, value);
            equationMap.computeIfAbsent(k2, k -> new HashMap<>()).put(k1, 1 / value);
        }
        double[] doubles = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String k1 = query.get(0);
            String k2 = query.get(1);
            doubles[i] = dfs(equationMap, k1, k2, new HashSet<>());
        }

        return doubles;
    }

    /**
     * dfs深度遍历，类似从根节点找到叶子节点一样
     */
    private static double dfs(Map<String, Map<String, Double>> equationMap, String k1, String k2, Set<String> path) {
        if (!equationMap.containsKey(k1) || !equationMap.containsKey(k2)) {
            return -1.0;
        }
        if (Objects.equals(k1, k2)) {
            return 1.0;
        }
        Map<String, Double> k1Map = equationMap.get(k1);
        if (null == k1Map || k1Map.isEmpty()) {
            return -1.0;
        }
        if (k1Map.containsKey(k2)) {
            return k1Map.get(k2);
        }
        path.add(k1);
        for (Map.Entry<String, Double> entry : k1Map.entrySet()) {
            String string = entry.getKey();
            if (path.contains(string)) {
                //防止死循环
                continue;
            }
            double value = entry.getValue();
            //System.out.println("k1:" + k1 + ", mid:" + string + ", k2" + k2 + ", path:" + path);
            double dfs = dfs(equationMap, string, k2, path);
            if (dfs != -1.0) {
                return value * dfs;
            }
        }
        return -1.0;
    }

}
