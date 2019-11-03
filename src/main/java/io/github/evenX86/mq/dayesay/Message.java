package io.github.evenX86.mq.dayesay;

import java.io.Serializable;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 3:50 PM
 */
public class Message implements Serializable {
    private String msg;

    public Message(String s) {
        msg = s;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
