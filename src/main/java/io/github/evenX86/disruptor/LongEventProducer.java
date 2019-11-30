package io.github.evenX86.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created with design-pattern-training
 *
 * 原生生产者
 * 与简单的队列比如ArrayListBlockedQueue相比，事件发布会更加复杂一点
 * 因为disruptor的ringbuffer需要初始化
 * 1. 要求2阶段发布
 * 推荐使用EventTranslator
 * @author xuyifei
 * @date 2019-11-27 6:53 PM
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb) {
        long sequence = ringBuffer.next();
        try {
            LongEvent event = ringBuffer.get(sequence);

            // fill with data
            event.setValue(bb.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }

    }

}
