package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/16 17:44
 */
public class 有序数组的平方 {
    public int[] sortedSquares(int[] A) {
        int head = 0, tail = A.length - 1;
        List<Integer> list = new ArrayList<>();
        while (head < tail) {
            if (Math.abs(A[head]) > Math.abs(A[tail])) {
                head++;
            } else if (Math.abs(A[head]) < Math.abs(A[tail])) {
                tail--;
            } else {
                if (head == tail || head + 1 == tail) break;
                else {
                    head++;
                    tail--;
                }
            }
        }
        tail = head + 1;
        while (head >= 0 && tail < A.length) {
            if (Math.abs(A[head]) >= Math.abs(A[tail])) {
                list.add(A[tail] * A[tail]);
                tail++;
            } else if (Math.abs(A[head]) < Math.abs(A[tail])) {
                list.add(A[head] * A[head]);
                head--;
            }
        }
        while (head >= 0) {
            list.add(A[head] * A[head]);
            head--;
        }
        while (tail < A.length) {
            list.add(A[tail] * A[tail]);
            tail++;
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;

    }
}
