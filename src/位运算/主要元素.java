package 位运算;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/28 21:49
 */
public class 主要元素 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int number = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            if (num == 0) {
                number = a;
                num++;
            } else {
                if (number == a)
                    num++;
                else
                    num--;
            }
        }
        if (num < 0) return -1;
        int n = 0;
        for (int a : nums) {
            if (a == number) n++;
        }
        return n >= (nums.length / 2 + 1) ? number : -1;
    }
}
