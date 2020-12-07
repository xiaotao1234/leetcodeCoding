package 二刷冲冲冲.排序算法;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Xiao Tao on 2020/3/4 11:49
 */
public class 堆排序 {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        arr = new int[]{1, 2, 1};
        largestPerimeter2(arr);
    }

    public static int largestPerimeter2(int[] A) {
        if (A == null || A.length < 3) return 0;
        Queue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2 - o1);
        int all = 0;
        for (int i = 0; i < A.length; i++) {
            queue.offer(A[i]);
            all = all + A[i];
            if (queue.size() == 3) {
                if (all - queue.peek() > queue.peek()) return all;
                all = all - queue.poll();
            }
        }
        return 0;
    }


    /**
     * 创建堆，
     *
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @param arr    待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }
}
