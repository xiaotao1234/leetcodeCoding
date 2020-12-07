package 每日一题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/28 13:01
 */
public class 独一无二的出现次数 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        int[] m = new int[2001];
        for (int a : arr) {
            m[a + 1000] = m[a + 1000] + 1;
        }
        for (int a : m) {
            if (a != 0 && set.contains(a)) return false;
            set.add(a);
        }
        return true;
    }

    public boolean uniqueOccurrences1(int[] arr) {
        if (arr == null || arr.length == 0) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) return false;
            else set.add(entry.getValue());
        }
        return true;
    }
}
