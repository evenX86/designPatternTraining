package io.github.evenX86.disruptor;

/**
 * Created with design-pattern-training
 *
 * carry data event
 * @author xuyifei
 * @date 2019-11-27 6:31 PM
 */
public class LongEvent {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
