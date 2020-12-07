package 每日一题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/10 8:20
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        boolean target = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int m = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = m;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }

            }
        }
        Arrays.sort(nums);
    }
}
