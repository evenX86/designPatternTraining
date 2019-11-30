package io.github.evenX86.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created with design-pattern-training
 *
 * disruptor 3.0 提供的Translator API ，可以屏蔽直接使用RingBuffer的复杂性
 * @author xuyifei
 * @date 2019-11-27 6:47 PM
 */
public class LongEventProducerWithTranslator {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 使用translator抽象了一层
     * 方便了使用
     */
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR_ONE_ARG =
            (event, sequence, arg0) -> event.setValue(arg0.getLong(0));

    public void onData(ByteBuffer byteBuffer) {
        ringBuffer.publishEvent(TRANSLATOR_ONE_ARG, byteBuffer);
    }


}
