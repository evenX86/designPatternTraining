package io.github.evenX86.mq.dayesay;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.spi.transport.CorbaAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created with design-pattern-training
 *
 * server zhangdaye
 * @author xuyifei
 * @date 2019-11-03 3:20 PM
 */
public class ZhangdayeSayServerService implements SayService {
    @Override
    public void say() {


    }

    public static void main(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
