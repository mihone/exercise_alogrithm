package com.exercise.algorithm.top150.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
*  @author mihone
*  @since 2024/12/7 18:17
*/
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

}
