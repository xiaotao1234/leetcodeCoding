package 位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/28 22:22
 */
public class 幂集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        get(nums, lists, 0, new ArrayList<>());
        return lists;
    }

    public void get(int[] nums, List<List<Integer>> lists, int now, List<Integer> list) {
        if (now >= nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        get(nums, lists, now + 1, list);
        list.add(nums[now]);
        get(nums, lists, now + 1, list);
        list.remove(list.size() - 1);
    }
}
