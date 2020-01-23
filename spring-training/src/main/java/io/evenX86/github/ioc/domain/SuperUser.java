package io.evenX86.github.ioc.domain;

import io.evenX86.github.ioc.annotation.Super;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-20 10:15 下午
 */
@Super
public class SuperUser extends User {
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "addr='" + addr + '\'' +
                "} " + super.toString();
    }
}
