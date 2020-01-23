package io.github.evenX86.concurrent.service;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-12-25 11:01 PM
 */
public class Add10kTest {
    private static long count = 0;
    private synchronized void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }
    public static long calc() throws InterruptedException {
        final Add10kTest add10kTest = new Add10kTest();
        Thread t1 = new Thread(() -> {add10kTest.add10K();});
        Thread t2 = new Thread(() -> {add10kTest.add10K();});

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calc());
    }
}
