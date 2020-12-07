package 二刷冲冲冲.TopK问题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/15 20:52
 */
public class 最大的第k个数 {

    public int TopK(int[] nums, int K) {  //找第K个最大的元素，时间复杂度nlgK
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//默认实现为小顶堆（即堆顶的元素总是比较意义上最小的元素，每次弹出会将当前堆中最小的元素弹出）,可通过传入比较器来转为大顶堆。
        for (int i : nums) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > K) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

    public int MinK(int[] nums, int K) {  //找第K个最小的元素，时间复杂度nlgK
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : nums) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > K) {
                priorityQueue.poll();//每次弹出比较意义上最小的，但是实际int值最大的。所以最后堆里剩下的元素是所有元素中最小的一些元素
            }
        }
        return priorityQueue.poll();
    }
}
