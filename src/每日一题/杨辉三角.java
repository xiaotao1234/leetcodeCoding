package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/6 14:26
 */
public class 杨辉三角 {
    public static void main(String[] strings) {
//        generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        get(lists, numRows);
        return lists;
    }

    public void get(List<List<Integer>> lists, int num) {
        if (num == 0) return;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (lists.size() != 0) {
            List<Integer> list1 = lists.get(lists.size() - 1);
            for (int i = 0; i < list1.size() - 1; i++) {
                list.add(list1.get(i) + list1.get(i + 1));
            }
            list.add(1);
        }
        lists.add(list);
        get(lists, num - 1);
    }
}
