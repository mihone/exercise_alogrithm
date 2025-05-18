package com.exercise.algorithm.lcr;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * LCR 041. 数据流中的移动平均值
*  @author mihone
*  @since 2025/5/18 14:11
*/
public class LCR041 {

    public static void main(String[] args) {

    }


    static class MovingAverage {

        ArrayList<Integer> list = new ArrayList<>();
        int size;
        int index = 0;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            list.add(val);
            if (list.size()<=size) {
                Integer i = list.stream().reduce(Integer::sum).orElse(0);
                return (double)i/list.size();
            }
            index++;
            int sum = 0;
            for (int i = index; i < index+size; i++) {
                sum += list.get(i);
            }
            return (double)sum/ size;

        }
    }
}
