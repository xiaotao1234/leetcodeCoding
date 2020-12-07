package 二刷冲冲冲.排序算法;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/8 19:37
 */
public class test {
    public void sortkp(int[] nums) {//快排
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        kpf(nums, 0, nums.length - 1);
    }

    public void kpf(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left;
        int r = right;
        int target = nums[left];
        while (l < r) {
            while (l < r && target < nums[r]) r++;
            while (l < r && target > nums[l]) l++;
            if (l < r) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
        nums[left] = nums[l];
        nums[l] = target;
        kpf(nums, left, l - 1);
        kpf(nums, l + 1, right);
    }

    public void sortmp(int[] nums) {//冒泡
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < target) {
                    nums[i] = nums[j];
                    nums[j] = target;
                    target = nums[i];
                }
            }
        }
    }

    public void sortcr(int[] nums) {//插入
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {  //若待插入数比前面有序数组的最后一个元素小，则其需要插入到前面数组中去
                int target = nums[i];
                for (int j = i; j >= 0; j++) {
                    if (j > 0 && nums[j - 1] > target) {  //如果当前数序号不为第一个（因为每次是对第j-1元素进行大小比较，如不合适将其存在j位置，
                        // 即后后移了一位，j=1,要比较第-1位，即当前元素为队头，代表其前面已经没有元素了，则需要直接插入到队头）
                        nums[j] = nums[j - 1];
                    } else {//若已经到了对头或者找到了比待插入元素小的元素，则将当前元素插入到这个元素序号，即j-1后面即第j位
                        nums[j] = target;
                        break;
                    }
                }
            }
        }
    }

    public void sortcr1(int[] nums) {//插入
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int target = nums[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && nums[j - 1] > target) {
                        nums[j] = nums[j - 1];
                    } else {
                        nums[j] = target;
                        break;
                    }
                }
            }
        }
    }

    public void sortgb(int[] nums) {
        if (nums == null || nums.length < 2) return;
        gb(nums, 0, nums.length - 1);
    }

    public void gb(int[] ints, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        gb(ints, left, mid);
        gb(ints, mid + 1, right);
        b(ints, left, mid, right);
    }

    public void b(int[] ints, int left, int mid, int right) {
        int l = left;
        int r = mid;
        int index = l;
        int[] nums = new int[ints.length];
        while (l < mid && r <= right) {
            if (ints[l] < ints[r]) {
                nums[index++] = ints[l++];
            } else {
                nums[index++] = ints[r++];
            }
        }
        while (l < mid) {
            nums[index++] = ints[l++];
        }
        while (r <= right) {
            nums[index++] = ints[r++];
        }
    }
}
