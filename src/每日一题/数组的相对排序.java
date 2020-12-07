package 每日一题;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/14 11:51
 */
public class 数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            Integer[] integers = new Integer[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                integers[i] = arr1[i];
            }
            Arrays.sort(integers, (o1, o2) -> {
                if (map.containsKey(o1) && map.containsKey(o2)) {
                    return map.get(o1) - map.get(o2);
                }
                if (map.containsKey(o1)) {
                    return 0;
                }
                if (map.containsKey(o2)) {
                    return 1;
                }
                return o1 - o2;
            });
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = integers[i];
            }
            return arr1;
    }
}
