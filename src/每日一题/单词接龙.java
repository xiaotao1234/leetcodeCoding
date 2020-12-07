package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/5 13:00
 */
public class 单词接龙 {

    public static void main(String[] args) {
        单词接龙 s = new 单词接龙();
        s.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        num = wordList.size() + 1;
        get(beginWord, endWord, wordList, 1);
        return num > wordList.size() ? 0 : num;
    }

    int num;

    public void get(String current, String endWord, List<String> wordList, int count) {
        if (current.equals(endWord)) {
            num = Math.min(count, num);
            return;
        }
        if (wordList == null || wordList.size() == 0) return;
        List<String> list = new ArrayList<>(wordList);
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (isSameOne(current, s)) {
                list.remove(i);
                get(s, endWord, list, count + 1);
                list.add(i, s);
            }
        }
    }

    public boolean isSameOne(String s1, String s2) {
        int record = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                record = record + 1;
                if (record > 1)
                    return false;
            }
        }
        return true;
    }
}
