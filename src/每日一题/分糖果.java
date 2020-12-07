package 每日一题;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/18 21:51
 */
public class 分糖果 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        }
        return set.size();
    }
}
