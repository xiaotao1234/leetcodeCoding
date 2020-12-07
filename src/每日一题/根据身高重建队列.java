package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/16 13:00
 */
public class 根据身高重建队列 {
    //将所有先按照身高逆序排序，身高相等的按照people[1]顺序排序，
    // 排序后，再进行的插入操作可以看作将矮个子插入到高个子中，矮个子
    // 高个子由于不会因为矮个子的插入而影响其people[1]的特性，插完后就得到正确的顺序
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? -1 :
                        (o1[0] < o2[0] ? 1 : o1[1] - o2[1]);
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
