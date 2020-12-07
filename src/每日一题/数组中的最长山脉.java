package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/25 0:24
 */
public class 数组中的最长山脉 {
    public int longestMountain(int[] A) {
        int[][] re = new int[A.length][2];
        int max = 0;
        int pre = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) continue;
            if (A[i] > A[i - 1]) {
                re[i][0] = re[i - 1][0] + 1;
                pre = re[i][0];
                continue;
            } else if (A[i] < A[i - 1]) {
                re[i][1] = re[i - 1][1] + 1;
                if (pre > 0) {
                    max = Math.max(max, pre + re[i][1] + 1);
                }
            } else {
                pre = 0;
            }
        }
        return max;
    }
}
