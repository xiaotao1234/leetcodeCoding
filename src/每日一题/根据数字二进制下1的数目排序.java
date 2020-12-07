package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/6 10:12
 */
public class 根据数字二进制下1的数目排序 {
    public int[] sortByBits(int[] arr) {
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = get(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (ints[i] > ints[j] || (ints[i] == ints[j] && arr[i] > arr[j])) {
                    int m = ints[i];
                    ints[i] = ints[j];
                    ints[j] = m;
                    m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
        return arr;
    }

    public int get(int i) {
        int m = 0;
        while (i != 0) {
            int k = i % 2;
            if (k == 1) m++;
            i = i / 2;
        }
        return m;
    }
}
