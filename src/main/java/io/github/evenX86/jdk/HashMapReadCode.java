package io.github.evenX86.jdk;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-09-18 6:29 PM
 */
public class HashMapReadCode {

    public static void main(String[] args) {
        System.out.println(tableSizeFor(45));

    }
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n >>> 1));
        n |= n >>> 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));

        n |= n >>> 4;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));

        n |= n >>> 8;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));

        n |= n >>> 16;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));

        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
