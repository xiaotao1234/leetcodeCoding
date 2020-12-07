package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/26 13:09
 */
public class 有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ints = new int[101];
        int[] ints1 = new int[101];
        int[] mem = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]] = ints[nums[i]] + 1;
        }
        for (int i = 1; i < ints.length; i++) {
            ints1[i] = ints1[i - 1] + ints[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ints1[nums[i]];
        }
        return nums;
    }
}
