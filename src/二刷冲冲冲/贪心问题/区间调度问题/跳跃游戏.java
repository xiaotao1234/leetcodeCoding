package 二刷冲冲冲.贪心问题.区间调度问题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/30 8:54
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {//将序列顺序后遍历
            if (k < i) return false;//若遍历到一个位置，但是根据k来判断发现不能到达到当前位置
            // （k已经是当前位置的前面的最远到达位置），那么就不能再继续遍历了
            k = Math.max(k,i+nums[i]);//否则能到达当前位置，那么就也能到当前的最远位置
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
