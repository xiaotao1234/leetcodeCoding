package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/3 13:01
 */
public class 计数质数 {//质数，除了1和本身外不能被其他数整除，不包含1
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int all = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) all++;
        }
        return all;
    }

    public boolean isPrime(int i) {
        if (i <= 0) return false;
        int s = (int) Math.sqrt(i);
        for (int j = 2; j <= s; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    public int countPrimes1(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime1(int num) {
        int max = (int)Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
