package 二刷冲冲冲.动态规划.最值问题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/25 18:44
 */
public class 数组中的最长山脉 {
    public int longestMountain(int[] A) {
        int[] dp1 = new int[A.length];
        int[] dp2 = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i != 0 && A[i] > A[i - 1]) dp1[i] = dp1[i - 1] + 1;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (i != A.length - 1 && A[i] > A[i + 1]) dp2[i] = dp2[i + 1] + 1;
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (dp1[i] > 0 && dp2[i] > 0) max = Math.max(max, dp1[i] + dp2[i] + 1);
        }
        return max;
    }
}
