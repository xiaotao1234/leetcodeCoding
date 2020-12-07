package 每日一题;

import java.util.Arrays;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/9 0:18
 */
public class 最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
        int[] nums = new int[points.length];
        int[] tmp = new int[2];
        for (int i = 0; i < points.length; i++) {
            nums[i] = get(points[i]);
        }
        for (int i = 0; i < K; i++) {
            int target = nums[i];
            for (int j = i; j < points.length; j++) {
                if (nums[j] < target) {
                    nums[i] = nums[j];
                    nums[j] = target;
                    tmp = points[i];
                    points[i] = points[j];
                    points[j] = tmp;
                }
            }
        }
        int[][] ints = new int[K][2];
        for (int i = 0; i < K; i++) {
            ints[i] = points[i];
        }
        return ints;
    }

    public int get(int[] nums) {
        return nums[0] * nums[0] + nums[1] * nums[1];
    }
}
