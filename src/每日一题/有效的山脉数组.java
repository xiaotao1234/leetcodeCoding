package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/3 13:07
 */
public class 有效的山脉数组 {
    public boolean validMountainArray(int[] A) {
        int head = 0;
        int tail = A.length - 1;
        while (head < A.length - 1) {
            if (A[head + 1] > A[head]) head++;
            else break;
        }
        while (tail > 0) {
            if (A[tail - 1] > A[tail]) tail--;
            else break;
        }
        return head == tail && head != 0 && head != A.length - 1;
    }
}
