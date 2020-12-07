package 每日一题;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/1 20:50
 */
public class 按序打印 {
    class Foo {
        AtomicInteger atomicInteger1 = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            atomicInteger1.addAndGet(1);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (atomicInteger1.get() != 1) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            atomicInteger2.addAndGet(1);

        }

        public void third(Runnable printThird) throws InterruptedException {
            while (atomicInteger2.get() != 2) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo1 {

        Lock lock = new ReentrantLock();
        volatile boolean firstComplete;
        volatile boolean sencondComplete;

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstComplete = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!firstComplete) {
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sencondComplete = true;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!sencondComplete) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo2 {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch1 = new CountDownLatch(1);

        public Foo2() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatch.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatch1.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatch1.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
