package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/1 9:16
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() == 0 && nums[i] == target) {
                list.add(i);
            }
            if (list.size() == 1 && nums[i] != target) {
                list.add(i - 1);
            }
            if (list.size() == 2) break;
        }
        if (list.size() == 1) list.add(nums.length - 1);
        if (list.size() == 0) return new int[]{-1, -1};
        return new int[]{list.get(0), list.get(1)};
    }

    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                break;
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            mid = left + (right - left) / 2;
        }
        if (left > right) return new int[]{-1, -1};
        for (int i = mid; i >= 0; i--) {
            if (nums[i] != target) {
                left = i + 1;
                break;
            }
            if (i == 0) left = 0;
        }
        for (int i = mid; i <= nums.length - 1; i++) {
            if (nums[i] != target) {
                right = i - 1;
                break;
            }
            if (i == nums.length - 1) right = nums.length - 1;
        }
        return new int[]{left, right};
    }

    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        //lower为true，找到最左边的target，为false找到最右边的target
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] == target)) {
                //lower && nums[mid] >= target的意思是说如果是找低位，则如果当前mid为大于或者等于target，都要尝试向再左找
                right = mid - 1;
                ans = mid;//用ans来记录下mid，因为在==target的情况下，mid就是上一个找到的target位置
            } else {
                left = mid + 1;
            }
            //总的来说，精妙之处就是依靠lower来控制当nums[mid] == target的情况下，当前的处理方式，是向左找还是向右找
        }
        return ans;
    }
}
