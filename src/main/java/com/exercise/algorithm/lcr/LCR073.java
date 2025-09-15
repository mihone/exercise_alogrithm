package com.exercise.algorithm.lcr;
/**
 * [REPEAT]
 * LCR 073. 爱吃香蕉的狒狒
*  @author mihone
*  @since 2025/9/15 21:36
*/
public class LCR073 {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low <= high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed-1;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            if (pile % speed!=0) {
                time += pile/speed +1;
            }else {
                time += pile/speed;
            }
        }
        return time;
    }

}
