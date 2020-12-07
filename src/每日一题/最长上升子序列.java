package 每日一题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/20 21:50
 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 1;
        for (int d : dp) {
            max = Math.max(max, d);
        }
        return max;
    }
}
