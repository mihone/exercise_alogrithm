package com.exercise.algorithm.lcr;

import java.util.ArrayList;

/**
 * LCR 042. 最近的请求次数
*  @author mihone
*  @since 2025/5/18 14:19
*/
public class LCR042 {

    public static void main(String[] args) {

    }


    static class RecentCounter {

        public RecentCounter() {

        }
        ArrayList<Integer> list = new ArrayList<>();

        public int ping(int t) {
            list.add(t);
            int count = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i)>=t-3000) {
                    count++;
                }else {
                    break;
                }

            }
            return count;

        }
    }
}
