package 每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/24 17:14
 */
public class 视频拼接 {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];//dp[i]定义为到视频的第i分钟时，需要的最小视频段数
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j < clips.length; j++) {
                if (clips[j][0] > i) continue;
                if (clips[j][1] < i) continue;
                dp[i] = Math.min(dp[i], dp[clips[j][0]] + 1);
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public int videoStitching1(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    public int videoStitching2(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);//合并小区间
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    public int videoStitching3(int[][] clips, int T) {//贪心
        int[] tan = new int[T];
        for (int[] ints : clips) {
            if (ints[0] < T)//排除片段起始时间已经超过了我们目标集合的
                tan[ints[0]] = Math.max(tan[ints[0]], ints[1]);//对每个起始点，找到其最大时间点，即把小区间剔除合并到大区间中，
            // 即为贪心做准备，即当在当前拼接一段时，当前拼接上的片段的起始到结束的一段就会变为我们的可搜索段，即因为当前视频段已经包含了
            // 起始到结束的这一段的视频，我们在这段之间的任一位置都能开始拼接下一段来使我们的视频向后继续拼接。
        }
        int pre = 0, tail = 0, ret = 0;
        for (int i = 0; i < T; i++) {
            tail = Math.max(tail, tan[i]);//取当前位置为起点的最大的后延视频与前面一段的结果的累计
            if (tail == i) return -1;//若前面段加上本位置的最大后延累计都未超过本位置，那么代表当前不能再被连接上
            if (i == pre) {//继续若当前遍历位置到达了前一次更新后延位置（前一段拼接上来的视频的尾位置）
                ret++;//代表一段的搜索结束了，需要把我们在这段上查找到的最大的后续段拼接上来使得视频继续向后延展，拼接段数加一
                pre = tail;//将查找到的新段拼接上
            }
        }
        return ret;
    }
}
