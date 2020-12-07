package 二刷冲冲冲.贪心问题.区间调度问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/30 8:31
 */
public class 互不相交的区间 {
    public int intervalScheduling(int[][] ints) {
        if (ints == null || ints.length == 0) return 0;
        Arrays.sort(ints, Comparator.comparingInt(o -> o[1]));
        int all = 1;
        int end = ints[0][1];
        for (int[] ints1 : ints) {
            if (ints1[0] > end) {
                all = all + 1;
                end = ints1[1];
            }
        }
        return all;
    }
}
