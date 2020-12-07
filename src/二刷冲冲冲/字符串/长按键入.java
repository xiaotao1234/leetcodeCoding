package 二刷冲冲冲.字符串;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/21 14:45
 */
public class 长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int nl = 0, tl = 0;
        char[] charsN = name.toCharArray();
        char[] charsT = typed.toCharArray();
        while (nl < name.length() && tl < typed.length()) {//最外层循环，当当前其中一个超出序号时退出循环
            if (charsN[nl] != charsT[tl]) return false;//若当前两个起始元素不相等，最匹配失败
            while (nl < name.length() && tl < typed.length() && charsT[tl] == charsN[nl]) {
                //将当前入序号之后两者所有能匹配的都进行匹配，直到不能再匹配为止
                nl++;
                tl++;
            }
            while (tl < name.length() && nl > 0 && charsN[nl - 1] == charsT[tl]) {
                //若后一个序列的后续和前一个序列的前一个元素依然能匹配上则，将后续元素的所有能匹配上得元素都进行排除
                tl++;
            }
        }
        return (tl >= typed.length() && nl >= name.length());//两个序列是。否都排除到了末尾了
    }
}
