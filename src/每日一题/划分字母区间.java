package 每日一题;

import 字符串.长按键入;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/22 13:23
 */
public class 划分字母区间 {

    public static void main(String[] args) {
        划分字母区间 s = new 划分字母区间();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] target = new int[26];
        for (int i = 0; i < S.length(); i++) {
            target[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(S.charAt(i));
            int s = i;
            i++;
            while (!set.isEmpty() && i < S.length()) {
                if (set.contains(S.charAt(i))) {
                    if (target[S.charAt(i) - 'a'] == i) set.remove(S.charAt(i));
                } else {
                    set.add(S.charAt(i));
                }
                i++;
            }
            i--;
            list.add(i - s + 1);
        }
        return list;
    }

    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public List<Integer> partitionLabels3(String S) {
        int[] ints = new int[S.length()];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i] - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, ints[chars[i] - 'a']);
            if (end == i) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    public List<Integer> partitionLabels4(String S) {
        int[] ints = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < S.length(); i++) {
            ints[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int start = 0;
        set.add(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                if (ints[chars[i] - 'a'] == i) set.remove(chars[i]);
            } else {
                set.add(chars[i]);
            }
            if (set.size() == 0) {
                list.add(i - start + 1);
                start = start + 1;
                set.add(chars[start]);
            }
        }
        return list;
    }
}
