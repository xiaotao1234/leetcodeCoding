package 二刷冲冲冲.动态规划.字符编辑问题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/7 13:44
 */
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) return m + n;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1] + 1,//替换
                            dp[i - 1][j] + 1,//删除
                            dp[i][j - 1]);//增加
                }
            }
        }
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return a > (b = b > c ? c : b) ? b : a;
    }
}
