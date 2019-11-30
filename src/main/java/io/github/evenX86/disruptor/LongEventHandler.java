package io.github.evenX86.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created with design-pattern-training
 *
 * consumer
 * handle event
 * @author xuyifei
 * @date 2019-11-27 6:43 PM
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) {
        System.out.println("Event : " + longEvent.getValue());
    }
}
