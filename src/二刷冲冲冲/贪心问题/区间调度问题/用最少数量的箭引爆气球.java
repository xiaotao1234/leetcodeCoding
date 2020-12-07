package 二刷冲冲冲.贪心问题.区间调度问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/30 8:42
 */
public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int all = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                all = all + 1;
                end = points[i][1];
            }
        }
        return all;
    }
}
