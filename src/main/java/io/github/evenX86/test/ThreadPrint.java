package io.github.evenX86.test;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-03-22 12:03 AM
 */
public class ThreadPrint {

    public static void main(String[] args) {
        Object object = new Object();
        Thread1 t1 = new Thread1(object);
        Thread2 t2 = new Thread2(object);
        t1.run();
        t2.run();
    }

}

class Thread1 implements Runnable {
    private final Object object;
    private Integer i=0;

    Thread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (i<10) {
            synchronized (object) {
                if (i++%2==0) {
                    System.out.println(i);
                    object.notify();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
class Thread2 implements Runnable {
    private final Object object;
    private Integer i=0;

    Thread2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (i<10) {
            synchronized (object) {
                if (i++%2!=0) {
                    System.out.println(i);
                    object.notify();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}