package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/28 9:28
 */
public class 剪绳子2 {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            res = res * 3;
            res = res % 1000000007;
            n = n - 3;
        }
        return (int) (res * n % 1000000007);
    }
}
