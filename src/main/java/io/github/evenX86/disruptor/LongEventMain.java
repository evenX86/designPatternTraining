package io.github.evenX86.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-27 7:01 PM
 */
public class LongEventMain {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l =0;true;l++) {
            bb.putLong(0,l);
            ringBuffer.publishEvent((event, sequence, arg0) -> event.setValue(bb.getLong(0)));
            Thread.sleep(1000);
        }
    }
}
