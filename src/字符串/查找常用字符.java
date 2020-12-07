package 字符串;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/14 13:00
 */
public class 查找常用字符 {
    public List<String> commonChars(String[] A) {
        List<Character> set = new ArrayList<>();
        if (A == null || A.length == 0) return new ArrayList<>();
        for (char c : A[0].toCharArray()) {
            set.add(c);
        }
        for (int i = 1; i < A.length; i++) {
            String s = A[i];
            List<Character> set1 = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (set.contains(c)) {
                    set1.add(c);
                }
            }
            set = set1;
        }
        List<String> list = new ArrayList<>();
        for (char c : set) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    public List<String> commonChars1(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : A[0].toCharArray()) {
            add(map, c);
        }
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> map1 = new HashMap<>();
            for (Character c : A[i].toCharArray()) {
                if (map.containsKey(c)) {
                    add(map1, c);
                    if (map.get(c) == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, map.get(c) - 1);
                    }
                }
            }
            map = map1;
        }
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                stringList.add(String.valueOf(entry.getKey()));
            }
        }
        return stringList;
    }

    public void add(Map<Character, Integer> map, Character character) {
        if (map.containsKey(character)) {
            map.put(character, map.get(character) + 1);
        } else {
            map.put(character, 1);
        }
    }


    public List<String> commonChars2(String[] A) {
        if (A == null || A.length == 0) return new ArrayList<>();
        int[] ints = new int[26];
        for (Character character : A[0].toCharArray()) {
            ints[character - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tmp = new int[26];
            for (Character character : A[i].toCharArray()) {
                if (ints[character - 'a'] > 0) {
                    ints[character - 'a']--;
                    tmp[character - 'a']++;
                }
            }
            ints = tmp;
        }
        List<String> list = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            list.add(String.valueOf(ints[i] + 'a'));
        }
        return list;
    }

}














