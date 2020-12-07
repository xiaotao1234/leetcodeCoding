package 字符串;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/21 13:02
 */
public class 长按键入 {

    public static void main(String[] args) {
        长按键入 s = new 长按键入();
        System.out.println(s.isLongPressedName("pyplrz", "ppyypllr"));
    }

    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) return false;
        int s1 = 0;
        int s2 = 0;
        char[] chars1 = name.toCharArray();
        char[] chars2 = typed.toCharArray();
        while (s1 < name.length() && s2 < typed.length()) {
            if (chars1[s1] != chars2[s2]) return false;
            while (s1 < name.length() && s2 < typed.length() && chars1[s1] == chars2[s2]) {
                s1++;
                s2++;
            }
            while (s2 < typed.length() && s1 > 0 && chars1[s1 - 1] == chars2[s2]) {
                s2++;
            }
        }
        return s1 >= name.length() && s2 >= typed.length();
    }

    public boolean isLongPressedName1(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int nameIndex = 0;
        int typeIndex = 0;
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        while (nameIndex < name.length() && typeIndex < typed.length()) {
            if (nameChar[nameIndex] != typedChar[typeIndex]) return false;
            while (nameIndex < name.length() && typeIndex < typed.length() && nameChar[nameIndex] == typedChar[typeIndex]) {
                nameIndex++;
                typeIndex++;
            }
            while (typeIndex < typed.length() && nameIndex > 0 && nameChar[nameIndex - 1] == typedChar[typeIndex]) {
                typeIndex++;
            }
        }
        return nameIndex >= name.length() && typeIndex >= typed.length();
    }

    public boolean isLongPressedName2(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int nameIndex = 0;
        int typeIndex = 0;
        char[] names = name.toCharArray();
        char[] types = typed.toCharArray();
        while (nameIndex < name.length() && typeIndex < typed.length()) {
            if (names[nameIndex] != types[typeIndex]) return false;
            while (nameIndex < name.length() && typeIndex < typed.length() && names[nameIndex] == types[typeIndex]) {
                nameIndex++;
                typeIndex++;
            }
            while (typeIndex < typed.length() && nameIndex > 0 && types[typeIndex] == names[nameIndex - 1]) {
                typeIndex++;
            }
        }
        return (nameIndex >= name.length() && typeIndex >= typed.length());
    }
}
