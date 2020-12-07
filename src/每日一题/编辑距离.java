package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/7 13:01
 */
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];//0到字符串长度，所以需要字符串长度+1的长度
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        for (int i = 0; i < word1.length(); i++) {//从一个字符串长度为0到另一个字符串需要增加另一个字符串长度的字符
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (char1[i] == char2[j]) {//若相等那么不需要操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {//否则进行操作
                    dp[i][j] = min(dp[i - 1][j - 1] + 1,//替换， 这里i-1  ,   j-1已经相等
                            dp[i - 1][j] + 1,//删除第i位   ， 这里i-1    ,   j已经相等，要i,j相等只需要删除第i个字符
                            dp[i][j - 1] + 1);//在第i位后插入一个和第j位相等的字符，
                }
            }
        }
        return dp[word1.length() + 1][word2.length() + 1];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
