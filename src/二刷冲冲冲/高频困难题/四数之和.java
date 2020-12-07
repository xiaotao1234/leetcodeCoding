package 二刷冲冲冲.高频困难题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/20 23:04
 */
public class 四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int tmp = nums[i] + nums[j] + nums[start] + nums[end];
                    if (tmp > target) {
                        end--;
                    } else if (tmp < target) {
                        start++;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    }
                }
            }
        }
        return lists;
    }
}
