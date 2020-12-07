package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/27 13:02
 */
public class 四数相加2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int all = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                all = map.getOrDefault(-C[i]-D[j], 0) + all;
            }
        }
        return all;
    }
}
