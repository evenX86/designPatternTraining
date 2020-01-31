package io.evenX86.github.bytecode.jvm;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 4:45 下午
 */
public class DemoStart {
    public static void main(String[] args) {
        Passenger a  = new ChinesePassenger();
        Passenger b = new ForeignPassenger();
        long currentTime = System.currentTimeMillis();
        for (int i = 1 ; i<= 2_000_000_000; i++) {
            if (i % 1_000_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - currentTime);
                currentTime = temp;
            }
            Passenger c = (i < 1_000_000_000) ? a : b;
            c.pass();
        }
    }
}
