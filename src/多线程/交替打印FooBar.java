package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/1 21:21
 */
public class 交替打印FooBar {//必须按照打印顺序来，且调用顺序不定，那么可能就需要等待和唤醒来纠正多线程的执行顺序，
    // JVM锁或者Lock都可以做到通过wait和notify/signall + 标志位,锁是为了等待，标志位是为了处理对当前状态的判断，
    // 即当前执行状态是否能满足当前逻辑的执行条件，执行条件满足则执行，否者就阻塞等待，如一开始线程2先进来了，判断执行
    // 条件发现不满足当前执行，则执行wait，直到线程1将标志位置为后，使标志满足线程2的执行条件且这个条件也阻止了置位前
    // 的自己的二次进入，然后尝试唤醒可能存在的被阻塞的线程，若有被阻塞的就被唤醒了，若没有那也不影响，反正其执行条件位
    // 也已经置位了，不会发生死锁

    // 而信号量不需要附加额外的执行条件，是因为Sample本身包含了一个当前的状态信息，即剩余信号量，在初始条件确定以后，
    // 线程二因为初始信号量为0，其必须等待线程1来为其附加release信号量，而线程一在acquire一个信号量之后，信号量也降到0了，
    // 又必须由线程二为其附加信号量。且本身的信号量不足时等待信号量的机制

    // CyclicBarrier + 标志位，CyclicBarrier是为了阻塞，标志位是为了保证执行顺序

    class FooBar {  //syn 锁  +  标识
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        volatile int s = 0;

        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized (this) {//加锁是awit调用的先决条件，wait时会释放锁。
                for (int i = 0; i < n; i++) {
                    while (s == 1) {
                        this.wait();//条件不满足，wait来等待条件满足时被唤醒，while是为了防范虚假唤醒，会释放锁
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();//条件已经满足
                    s++;//条件改变
                    this.notifyAll();//唤醒另一个等待
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (this) {
                for (int i = 0; i < n; i++) {
                    while (s == 0) {
                        this.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    s--;
                    this.notifyAll();
                }
            }
        }
    }


    class FooBar1 { // Condition条件锁  +  标志变量
        private int n;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        volatile boolean f = true;

        public FooBar1(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (!f) {
                        condition1.await();//条件不满足等待
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    f = false;
                    condition2.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (f) {
                        condition2.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    f = true;
                    condition1.signalAll();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class FooBar2 { //信号量 Semaphore，acquire(x)表示申请x的信号量（acquire()表示申请1），
        // 申请到就讲信号量减少对应申请值，否者阻塞等待直到被唤醒且申请成功。
        private int n;
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphore1.acquire();//申请一个
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphore2.release();//释放一个
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                semaphore2.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphore1.release();
            }
        }
    }

    class FooBar3 {// CyclicBarrier + 标志位，CyclicBarrier是为了阻塞，标志位是为了保证执行顺序
        private int n;

        public FooBar3(int n) {
            this.n = n;
        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        boolean f = true;

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (!f) ;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                try {
                    f = false;
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                f = true;
            }
        }
    }
}
