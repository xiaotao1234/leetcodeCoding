package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/12/7 10:24
 */
public class 翻转矩阵后的得分 {
    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 1; i < A[0].length; i++) {
            int all = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) all++;
            }
            if (all * 2 < A.length) {
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = A[j][i] == 0 ? 1 : 0;
                }
            }
        }
        int all = 0;
        for (int i = 0; i < A.length; i++) {
            int k = 0;
            for (int j = 0; j < A[0].length; j++) {
                k = k * 2 + A[i][j];
            }
            all = all + k;
        }
        return all;
    }
}
