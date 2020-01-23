package io.github.evenX86.mq.dayesay;

/**
 * Created with design-pattern-training
 *
 * server zhangdaye
 * @author xuyifei
 * @date 2019-11-03 3:20 PM
 */
public class ZhangdayeSayServerService implements SayService {
    @Override
    public void say() {


    }

    public static void main(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
