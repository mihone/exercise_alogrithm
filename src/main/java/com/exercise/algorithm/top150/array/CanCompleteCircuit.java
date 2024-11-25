package com.exercise.algorithm.top150.array;

/**
 * [REPEAT]
 * 134. 加油站
 *
 * @author mihone
 * @since 2024/11/25 7:57
 */
public class CanCompleteCircuit {

    public static void main(String[] args) {

    }

    //1 2 3 4 5
    //3 4 5 1 2
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

}
