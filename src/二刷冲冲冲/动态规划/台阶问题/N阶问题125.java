package 二刷冲冲冲.动态规划.台阶问题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/21 0:04
 */
public class N阶问题125 {
    public int waysToStep(int n) {//递归
        get(n);
        return k;
    }

    int k = 0;

    public void get(int x) {
        if (x == 0) {
            k++;
            return;
        }
        if (x >= 1) get(x - 1);
        if (x >= 2) get(x - 2);
        if (x >= 5) get(x - 5);
    }

    public int waysToStep2(int n) {//动态规划
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (i > 0) dp[i] = dp[i - 1] + 1;
            if (i > 1) dp[i] = dp[i - 2] + 1;
            if (i > 4) dp[i] = dp[i - 5] + 1;
        }
        return dp[n];
    }
}
