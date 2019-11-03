package io.github.evenX86.java.base;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-01 5:07 PM
 */
public class LoopTest {
    public static void main(String[] args) {

        int[] arr = new int[64 * 1024 * 1024];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 3;
        }

        System.out.println(System.currentTimeMillis() - startTime + " ms");

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i += 16) {
            arr[i] *= 3;
        }

        System.out.println(System.currentTimeMillis() - startTime2 + " ms");

    }
}
