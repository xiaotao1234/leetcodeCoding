package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/8 22:25
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        char c;
        for (int i = 0; i < s.length / 2; i++) {
            c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
    }
}
