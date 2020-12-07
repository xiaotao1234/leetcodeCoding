package 二刷冲冲冲.贪心问题.区间调度问题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/30 8:36
 */
public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int all = 1;
        int end = intervals[0][1];
        for (int[] ints : intervals) {
            if (ints[0] >= end) {
                end = ints[1];
                all = all + 1;
            }
        }
        return intervals.length - all;
    }
}
