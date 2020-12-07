package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/4 13:00
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] ints : intervals) list.add(ints);
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] == intervals[i][0])
            if (intervals[i][0] > newInterval[1]) {
                if (i == 0) list.add(0, newInterval);
                else {
                    if (newInterval[0] > intervals[i - 1][1]) list.add(i, newInterval);
                    else list.get(i - 1)[1] = newInterval[1];
                }
                break;
            }
            if (i == intervals.length - 1) {
                if (intervals[i][1] > newInterval[0]) list.get(i)[1] = newInterval[1];
                else list.add(newInterval);
            }
        }
        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < ints.length; i++) ints[i] = list.get(i);
        return ints;
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] ints : intervals) list.add(ints);
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {

            }
            if (intervals[i][0] > newInterval[1]) {
                if (i == 0) list.add(0, newInterval);
                else {
                    if (newInterval[0] > intervals[i - 1][1]) list.add(i, newInterval);
                    else list.get(i - 1)[1] = newInterval[1];
                }
                break;
            }
            if (i == intervals.length - 1) {
                if (intervals[i][1] > newInterval[0]) list.get(i)[1] = newInterval[1];
                else list.add(newInterval);
            }
        }
        int[][] ints = new int[list.size()][2];
        for (int i = 0; i < ints.length; i++) ints[i] = list.get(i);
        return ints;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

}
