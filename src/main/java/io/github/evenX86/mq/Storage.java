package io.github.evenX86.mq;

/**
 * Created with design-pattern-training
 *
 * 消息队列实战代码
 *
 * K V 存储抽象
 * @author xuyifei
 * @date 2019-09-28 12:28 PM
 */
public interface Storage<K,V> {

    /**
     * 根据key 访问数据
     * @param key 数据key
     * @return 数据值
     */
    V get(K key);
}
