package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/1 22:32
 */
public class 打印零与奇偶数 {
    class ZeroEvenOdd {
        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        private int n;
        boolean isj = true;
        boolean isz = true;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!isz) ;
                printNumber.accept(0);
                try {
                    isz = false;
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) continue;
                while (isz) ;
                while (!isj) ;
                printNumber.accept(i);
                isz = true;
                isj = false;
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) continue;
                while (isz) ;
                while (isj) ;
                printNumber.accept(i);
                isz = true;
                isj = true;
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ZeroEvenOdd1 {

        private int n;

        private volatile int state;

        private volatile boolean control = true;

        public ZeroEvenOdd1(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (state != 0) {
                    Thread.yield();
                }
                printNumber.accept(0);
                if (control) {
                    state = 1;
                } else {
                    state = 2;
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                while (state != 2) {
                    Thread.yield();
                }
                printNumber.accept(i);
                control = true;
                state = 0;
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                while (state != 1) {
                    Thread.yield();
                }
                printNumber.accept(i);
                control = false;
                state = 0;
            }
        }
    }
}
