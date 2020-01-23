package io.github.evenX86.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-08 6:54 下午
 */
public class CompletableFutureTest {

    public void test() throws InterruptedException {
        CountDownLatch waitLatch = new CountDownLatch(1);

        CompletableFuture<?> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Wait");
                waitLatch.await(); //cancel should interrupt
                System.out.println("Done");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                throw new RuntimeException(e);
            }
        });

        sleep(10); //give it some time to start (ugly, but works)
        future.cancel(true);
        waitLatch.countDown();
        System.out.println("Cancel called");

        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        sleep(100); //give it some time to finish
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureTest test = new CompletableFutureTest();
        test.test();
    }
}
