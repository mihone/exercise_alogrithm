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

    public int canCompleteCircuit222(int[] gas, int[] cost) {

        int[] plus = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            plus[i] = gas[i] - cost[i];
            sum += plus[i];
        }
        if (sum < 0) {
            return -1;
        }
        for (int i = 0; i < plus.length; i++) {
            int cur = 0;
            int index = i;
            while ((index == i || index % plus.length != i) && cur >= 0) {
                cur += plus[index%plus.length];
                index++;
            }
            if (cur>=0) {
                return i;
            }
        }
        return -1;
    }

}
