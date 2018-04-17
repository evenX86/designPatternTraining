package io.github.evenX86.singleton;

/**
 * 双重检测版单例模式
 *
 *
 */
public class DoubleCheckSingle {
    private static volatile DoubleCheckSingle instance; //使用volatile 防止其他线程看到了初始化到了一半的实例，禁止内存重排序，使写发生在读前。
    private DoubleCheckSingle(){
    }
    public static DoubleCheckSingle getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingle.class){
                if (instance == null) { // 有可能会有线程同时等待，所以在同步代码块中还需要对instance增加判断
                    instance = new DoubleCheckSingle();
                }
            }
        }
        return instance;
    }


}
