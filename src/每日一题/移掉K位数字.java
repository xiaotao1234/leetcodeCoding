package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/15 17:25
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            list.add(Integer.valueOf(String.valueOf(num.charAt(i))));
        }
        while (k > 0) {
            if (list.size() == 1) return "0";
            int length = list.size();
            for (int i = 0; i < length - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    list.remove(i);
                    break;
                } else if (i == list.size() - 2) {
                    list.remove(list.size() - 1);
                    break;
                }
            }
            while (list.size() > 0 && list.get(0) == 0) {
                list.remove(0);
            }
            if (list.size() == 0) return "0";
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : list) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
