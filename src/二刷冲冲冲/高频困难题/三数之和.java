package 二刷冲冲冲.高频困难题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/20 22:43
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                if (tmp == 0) {
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (tmp > 0) {
                    end--;
                } else start++;
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums == null || nums.length < 3) return lists;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int tmp = nums[start] + nums[i] + nums[end];
                    if (tmp == 0) {
                        lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (tmp > 0) {
                        end--;
                    } else start++;
                }
            }
            return lists;
    }
}
