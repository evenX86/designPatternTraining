package io.github.evenX86.java.base;

import org.junit.Test;

/**
 * Created with design-pattern-training
 * <p>
 * gc safepoint test
 * int has no count loop saftpoint code
 *
 * @author xuyifei
 * @date 2019-10-27 8:06 PM
 */
public class SafepointTest {
    static double sum = 0;

    public static void foo() {
        long current = System.currentTimeMillis();
        for (long i = 0; i < 50_000_000; i++) {
            sum += Math.sqrt(i);
        }
        System.out.println("foo : " + (System.currentTimeMillis() - current) + " ms");

    }

    public static void bar() {
        long current = System.currentTimeMillis();
        for (int i = 0; i < 50_000_000; i++) {
            new Object().hashCode();
        }
        System.out.println("bar : " + (System.currentTimeMillis() - current) + " ms");
    }

    public static void main(String[] args) {
            foo();
    }
}
