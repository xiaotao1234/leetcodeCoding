package 双指针;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/12 18:13
 */
public class 数组中的kdiff数对 {
    public int findPairs(int[] nums, int k) {//双指针
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int pos1 = i;
            int pos2 = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (pos1 < pos2) {
                if (Math.abs(nums[pos1] - nums[pos2]) == k) {
                    index++;
                    break;
                }
                pos2--;
            }
        }
        return index;
    }

    public int findPairs1(int[] nums, int k) {//hash 法，巧妙的每次存放最小值来进行去重，因为每次存放的都是较小的一个，1，2|2，3  是两个，但是若一个存大一个存小，就会导致两次都存2，只有一个了，但是始终存最大或最小，
        // 及若下次还是和这个数有关的组合，要么比他大，那么这个组合就是已经存在的组合了，那么存的是已经存在的值，达到了重的目的，要么比他小，那存的就不是这个数了，存的就是更小的那个数，不会被去重，
        Set<Integer> set = new HashSet<>();//找到的目标元素集合
        Set<Integer> saw = new HashSet<>();//遍历过的元素，作为查找集合
        for (int num : nums) {
            if (saw.contains(num - k)) {//若遍历过的元素中有木标元素，则添加这个元素
                set.add(num - k);//存较小值，为了去重
            }
            if (saw.contains(k + num)) {//同上
                set.add(num);
            }
            saw.add(num);//将当前元素添加到遍历集合，不能抛弃，因为他可能还能与其他元素组合达成目标，最终每一个元素都和其他元素拼过，判断过,(每一个元素都向前拼，每个元素都保证了自己和自己前面的元素拼过，而与后面元素的拼又由后面元素来负责)
        }
        return set.size();
    }

    public int findPairs2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int num : nums) {
            if (col.contains(num - k)) {
                set.add(num);//存较大值，为了去重
            }
            if (col.contains(k + num)) {
                set.add(k + num);
            }
            col.add(num);
        }
        return set.size();
    }

}
