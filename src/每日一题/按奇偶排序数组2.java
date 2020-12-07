package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/12 8:29
 */
public class 按奇偶排序数组2 {
    public int[] sortArrayByParityII(int[] A) {
        int index = 1;
        for (int i = 0; i < A.length; i = i + 2) {
            if (A[i] % 2 == 1) {
                while (index < A.length) {
                    if (A[index] % 2 != 0) {
                        index = index + 2;
                    }
                    int x = A[index];
                    A[index] = A[i];
                    A[i] = x;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        按奇偶排序数组2 s = new 按奇偶排序数组2();
        final int[] ints = new int[2];
        ints[0] = 1;
        ints[1] = 2;
        ints[1] = 3;
        test t = new test(ints);
        test t1;
        try {
            t1 = (test) t.clone();
            System.out.println(ints[1]);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static class test implements Cloneable {
        int a = 0;
        int[] c;

        public test(int[] c) {
            this.c = c;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}
