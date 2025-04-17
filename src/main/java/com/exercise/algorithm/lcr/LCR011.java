package com.exercise.algorithm.lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * [REPEAT]
 * LCR 011. 连续数组
 *
 * @author mihone
 * @since 2025/4/17 21:53
 */
public class LCR011 {

    public static void main(String[] args) {
        LCR011 lcr011 = new LCR011();
        lcr011.findMaxLength(new int[]{0, 1, 0});

    }

    //超时
    public int findMaxLength1(int[] nums) {
        int max = 0;


        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero == one) {
                max = Math.max(max, i + 1);
            }
            int k = 0;
            while (k < i) {
                if (nums[k] == 0) {
                    zero--;
                } else {
                    one--;
                }
                if (zero == one) {
                    max = Math.max(max, i - k );
                    break;
                }
                k++;

            }


        }
        return max;

    }


    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

}
