package 每日一题;

import java.util.*;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/1 18:13
 */
public class 单词拆分2 {

    public static void main(String[] args) {
        单词拆分2 s = new 单词拆分2();
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(s.wordBreak("catsanddog", list));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] lists = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String ss : wordDict) {
                if (i + 1 >= ss.length() && (i + 1 == ss.length() || lists[i + 1 - ss.length()] != null) && s.startsWith(ss, i + 1 - ss.length())) {
                    List<String> list = lists[i];
                    if (lists[i] == null) {
                        list = new ArrayList<>();
                        lists[i] = list;
                    }
                    if (i != ss.length()) {
                        if (lists[i + 1 - ss.length()] != null)
                            for (String s1 : lists[i + 1 - ss.length()]) {
                                list.add(s1 + " " + ss);
                            }
                    } else {
                        list.add(ss);
                    }
                }
            }
        }
        return lists[s.length() - 1];
    }


    Map<String, List<String>> caches = new HashMap<>();

    public List<String> wordBreak1(String s, List<String> wordDict) {
        return get(s, wordDict, 0);
    }

    public List<String> get(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if (caches.containsKey(s.substring(offset))) {
            return caches.get(s.substring(offset));
        }
        List<String> stringList = new ArrayList<>();
        for (String s1 : wordDict) {
            if (s1.equals(s.substring(offset, Math.min(offset + s1.length(), s.length())))) {
                List<String> strings = get(s, wordDict, offset + s1.length());
                for (String m : strings) {
                    stringList.add((s1 + " " + m).trim());
                }
            }
        }
        caches.put(s.substring(offset), stringList);
        return stringList;
    }
}
