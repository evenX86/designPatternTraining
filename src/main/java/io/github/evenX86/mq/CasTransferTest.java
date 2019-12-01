package io.github.evenX86.mq;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with design-pattern-training
 *
 * 使用cas实现转账服务
 * @author xuyifei
 * @date 2019-12-01 5:06 PM
 */
public class CasTransferTest {
    static Integer balance = 0;
    private static AtomicInteger atomicBalance = new AtomicInteger(0);
    public static void main(String[] args) {
        int count = 100000;
        long startTime = System.currentTimeMillis();
        Lock lock = new ReentrantLock();
        for (int i=0;i<count;i++) {
            CompletableFuture.runAsync(() ->  transferWithLock(1, lock));
        }
        while (balance < count) {

        }
        System.out.println("Time Used : " + (System.currentTimeMillis() - startTime) + " ms");
        System.out.println(balance);
    }


    public static void transferWithCas(int amount) {
        atomicBalance.addAndGet(amount);

    }

    public static void transferWithLock(int amount, Lock lock) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
}
