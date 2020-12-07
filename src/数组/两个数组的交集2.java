package 数组;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/14 17:49
 */
public class 两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                int value = map.get(i);
                if (value == 1) map.remove(i);
                else map.put(i, value - 1);
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {//数组已排序
        List<Integer> list = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) index1++;
            else if (nums1[index1] > nums2[index2]) index2++;
            else {
                list.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
