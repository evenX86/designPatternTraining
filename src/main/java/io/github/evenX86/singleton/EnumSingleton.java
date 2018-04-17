package io.github.evenX86.singleton;

/**
 * 推荐单例的实现！
 *
 * 枚举类实现的单例模式
 * 类似
 *  public final class MySingleton {
        public final static MySingleton INSTANCE = new MySingleton();
    }
 */
public enum EnumSingleton {
    INSTANCE;

    // instance vars, constructor
    private final Integer A;

    EnumSingleton()
    {
        // Initialize the variable
        System.out.println("Initialize the variable");
        A = 1;

    }

    // Static getter
    public static EnumSingleton getInstance()
    {
        return INSTANCE;
    }

    public Integer getConnection()
    {
        return A;
    }
}
