package 二刷冲冲冲.高频困难题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/18 22:15
 */
public class 分发糖果 {
    public int candy(int[] ratings) {
        int[] intLeft = new int[ratings.length];
        int[] intRight = new int[ratings.length];
        Arrays.fill(intRight, 1);
        Arrays.fill(intLeft, 1);
        for (int i = 1; i < intRight.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                intRight[i] = intRight[i - 1] + 1;
            }
        }
        int all = intRight[ratings.length - 1];
        for (int i = intRight.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                intLeft[i] = intLeft[i + 1] + 1;
            }
            all = Math.max(intLeft[i], intRight[i]) + all;
        }
        return all;
    }

    public int candy1(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
