package 二刷冲冲冲.排序算法;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/8 20:35
 */
public class 冒泡排序 {//稳定排序
    public void sort(int[] nums) {//有序顺序是从大到小
        for (int i = 0; i < nums.length - 1; i++) {// 对 0-- length-1 进行两两对比较，在第一次比较后，
            // 最大的数到了最后，即冒泡，然后再把把应该在倒数第二的数冒过去，因此称之为冒泡，
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
