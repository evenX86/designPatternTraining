package io.github.evenX86.test;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-09-24 12:08 PM
 */
public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;
    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }
    public static void main(String[] args) {
        String str1 = "HelloFlyapi";
        String str4 = "Hello";
        String str5 = "Flyapi";
        String str7 = str4 + str5;

        System.out.println(str1 == str7);
    }


}
