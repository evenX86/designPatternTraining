package io.github.evenX86.mq;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with design-pattern-training
 *
 * https://www.jianshu.com/p/c4e4d55706ff
 * @author xuyifei
 * @date 2019-09-28 12:33 PM
 */
public class LruCacheImpl<K,V> extends LruCache<K,V> {
    /**
     * 存储节点的hash
     */
    private Map<K,Node<V>> keyNodeMap = new HashMap<>();
    private Node<V> head = null;
    private Node<V> tail = null;

    private static class Node<V> {
        V item;
        Node<V> next;
        Node<V> prev;

        Node(Node<V> prev, V element, Node<V> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public LruCacheImpl(int capacity, Storage<K,V> lowSpeedStorage) {
        super(capacity, lowSpeedStorage);
    }


    @Override
    public V get(K key) {
        // 映射中含有该key 则到链表中查询
        if (keyNodeMap.containsKey(key)) {
            Node<V> node = keyNodeMap.get(key);
            // 将当前节点删除，并设置其为头节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
            return node.item;
        } else {
            // hash中没有该key，则从低速缓存中取出插入到头部
            V v1 = lowSpeedStorage.get(key);
            Node<V> vNode = new Node<>(null, v1, head);
            if (keyNodeMap.size() > capacity) {
                // todo 使用map的size 来记录长度不够准确
                // 超过长度删除尾节点
                tail.prev.next = null;

            }

        }
        return null;
    }
}
