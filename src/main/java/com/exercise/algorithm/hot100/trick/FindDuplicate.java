package com.exercise.algorithm.hot100.trick;
/**
 * [REPEAT]
 * 287. 寻找重复数
*  @author mihone
*  @since 2025/3/16 16:44
*/
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2}));

    }
    // 1 3 4 2 2
    // 1 3
    // 3 4
    // 2 4
    // 4 4
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int ret = 0;
        slow = nums[slow];
        while (ret != slow) {
            ret = nums[ret];
            slow = nums[slow];
        }
        return slow;

    }
}
