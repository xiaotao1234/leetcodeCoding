package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/7 19:52
 */
public class 颜色分类 {
    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length, l = 0;
        while (l < tail) {
            if (nums[l] == 0) {
                swap(nums, head, l);
                head++;
                l++;
            } else if (nums[l] == 1) {
                l++;
            } else {
                tail--;
                swap(nums, tail, l);
            }
        }
    }

    public void swap(int[] nums, int l1, int l2) {
        int l = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = l;
    }
}
