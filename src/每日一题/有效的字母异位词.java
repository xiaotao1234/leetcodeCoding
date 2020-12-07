package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/22 9:37
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (char c : s.toCharArray()) {
            ints[c - 'a'] = ints[c - 'a'] + 1;
        }
        for (char c : t.toCharArray()) {
            if (ints[c - 'a'] == 0) return false;
            ints[c - 'a'] = ints[c - 'a'] - 1;
        }
        for (int i : ints) {
            if (i > 0) return false;
        }
        return true;
    }
}
