package 每日一题;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/29 21:28
 */
public class 三角形的最大周长 {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (is(A[i], A[i - 1], A[i - 2])) return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }

    public boolean is(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public int largestPerimeter1(int[] A) {
        if (A == null || A.length < 3) return 0;
        List<Integer> list = new ArrayList<>();
        int index = 0, t;
        while (index < A.length) {
            for (int i = index; i < A.length; i++) {
                if (A[index] < A[i]) {
                    t = A[index];
                    A[index] = A[i];
                    A[i] = t;
                }
            }
            list.add(A[index]);
            if (list.size() == 3) {
                if (list.get(0) < list.get(1) + list.get(2)) {
                    return list.get(0) + list.get(1) + list.get(2);
                } else {
                    list.remove(0);
                }
            }
            index++;
        }
        return 0;
    }

    public int largestPerimeter2(int[] A) {
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
}
