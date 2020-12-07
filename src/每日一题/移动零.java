package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/19 8:59
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {//统计0，然后搬移，尾部直接赋0；
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {//快排的思想
        //将0的起始位置作为一个中间值，将所有的0都不为0的数交换，最后所有的非零值被交换到左边而0都被交换到右边
        //虽然快排是一个不稳定排序但是这里要求稳定性，但是因为快排的不稳定性来自于在一次比较完成后枢纽元素的归位时，
        //然而这里的枢纽元素被定为0，且因为右边的值都是0，所以可以在一遍遍历的时候一遍移动这个枢纽元素，即将左边元素和枢纽
        //元素进行交换，枢纽元素（或者说枢纽段）就会在交换过程中慢慢的被交换到他的最终位置，无需最终的交换。没有了不稳定排序的源头
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;//j指针指示第一个0的起始位置
        for (int i = 0; i < nums.length; i++) {//i指示在0之后的第一个非0的起始位置，这个位置当前还未判断，
            // 可能为0，也可能非0，为0的话就向后顺延，如下当为0直接不做任何操作，把i指针挪动到下一位，
            // 不为0的话，就将前面的第一个0和这个不为0的数交换位置，那么原本第一个为0的数变为了非0，那么用于指示第一个
            // 为0的指针j也要顺序后移，然后继续对下一个未判断的位置继续判断，
            // 这里需要说明的是，在开始还未找到第一个0时，即每一个nums[i]!=0判断都为true，那么J和I会保持同增，相当于
            // 每次进行了自己对自己的交换，这种自己对自己的交换显然是多余的，由此衍生了优化解法
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {//思路二的优化
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// 上面解法的优化解法，即判断当前0的区间是否有数，因为有数才会需要将当前非0数和前面的0进行
                    //搬移互换操作，而如果这个区间都不存在或者说没有元素存在，那么根本就无需进行交换。
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes11(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public void moveZeroes21(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
