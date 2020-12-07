package 字符串;

import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/19 17:20
 */
public class 比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {//栈
        return (get(S).equals(get(T)));
    }

    public String get(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public boolean backspaceCompare1(String S, String T) {//双指针
        int sl = S.length() - 1;
        int tl = T.length() - 1;
        int sr = 0, tr = 0;
        while (sl > 0 && tl > 0) {
            char ss = 0;
            while (sl > 0) {
                ss = S.charAt(sl);
                if (ss == '#') {
                    sr++;
                    ss = ' ';
                } else if (sr > 0) {
                    sl--;
                    sr--;
                    ss = ' ';
                } else break;
            }
            char tt = 0;
            while (tl > 0) {
                tt = S.charAt(tl);
                if (tt == '#') {
                    tr++;
                    tt = ' ';
                } else if (tr > 0) {
                    tl--;
                    tr--;
                    tt = ' ';
                } else break;
            }
            sl--;
            tl--;
            if (tt == ss && ss != 0) continue;
        }
        return (sl < 0 && tl < 0);
    }
}
