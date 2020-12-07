package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/8 9:32
 */
public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[0] - prices[i], dp[1]);
        }
        return dp[0];
    }
}
