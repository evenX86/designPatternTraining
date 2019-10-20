package io.github.evenX86.mq;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-09-28 12:29 PM
 */
public abstract class LruCache<K,V> implements Storage<K,V> {
    protected final int capacity;
    protected final Storage<K,V> lowSpeedStorage;

    public LruCache(int capacity, Storage<K, V> lowSpeedStorage) {
        this.capacity = capacity;
        this.lowSpeedStorage = lowSpeedStorage;
    }
}
