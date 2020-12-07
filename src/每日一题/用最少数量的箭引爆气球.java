package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/23 22:16
 */
public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int right = points[0][1];
        int num = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                num++;
                right = points[i][1];
            }
        }
        return num;
    }

    // 贪心：如果要用最少的箭爆破所有的气球，那么这些箭需要能穿过尽可能多的气球，箭要从重叠（交集）尽可能多的地方射出。
    // 问题转化：这题其实就是求这些气球表示的区间中，形成的交集区域最少有多少个
    // 先排序，排序规则：先按起点排序，再按终点排序
    public static int findMinArrowShots1(int[][] points) {
        if (points.length <= 1) return points.length;

        // 【出错】：不能使用a-b来比较，差值过大会溢出，应该使用Integer.compare(a,b)比较
        // Arrays.sort(points, (p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1]);
        Arrays.sort(points, (p1, p2) -> p1[0] != p2[0] ? Integer.compare(p1[0], p2[0]) : Integer.compare(p1[1], p2[1]));

        Integer holdStart = points[0][0]; // 当前维持的交集起点
        Integer holdEnd = points[0][1]; // 当前维持的交集终点
        int counts = 0; // 当前收集到的交集数量

        for (int i = 1; i < points.length; i++) {
            int[] point = points[i]; // 当前点
            int curStart = point[0];
            int curEnd = point[1];

            if (curStart > holdEnd) { // 当前区间开始位置大于当前维持的交集终止位置
                // 形成一个新的交集区间
                holdStart = curStart;
                holdEnd = curEnd;
                counts++; // 增加一个交集数量
            } else { // 当前区间的开始位置 <= 当前维持的交集end，说明与当前的交集存在重叠
                // 看是否需要缩短当前的交集范围
                holdStart = Math.max(holdStart, curStart);
                holdEnd = Math.min(holdEnd, curEnd);
            }

        }

        counts++; // 【勿忘】：每次都是后面的区间结算前面的交集，不要忘记手动结算最后一个交集

        return counts;
    }
}
