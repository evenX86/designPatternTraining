package io.github.evenX86.concurrent;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-10-15 6:05 PM
 */
public class BlockQueue<T> {
    final Lock lock = new ReentrantLock();
    final Condition  notFull = lock.newCondition();
    final Condition  notEmpty = lock.newCondition();

    void enq(T x) {
        lock.lock();
        try {

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        int hash = 30;
        int n = 16;
        int mod = (n-1) & hash;
        System.out.println(Integer.toBinaryString(hash));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(mod<<1));

        System.out.println((n-1) & hash);
        System.out.println(hash % n);
    }

}
