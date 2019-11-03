package io.github.evenX86.mq.dayesay;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static io.github.evenX86.mq.dayesay.DayeCommonsUtil.LI;
import static io.github.evenX86.mq.dayesay.DayeCommonsUtil.ZH;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 3:48 PM
 */
public class LidayeSayMsgHandler extends SimpleChannelInboundHandler<Message> {

    private int cnt = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        if (ZH[0].equals(message.getMsg())) {
            ctx.write(LI[0]);
            ctx.write(LI[1]);
        } else if (ZH[1].equals(message.getMsg())) {
            ctx.write(LI[2]);
        } else {
            cnt ++;
            if (cnt == 10000) {
                System.out.println(System.currentTimeMillis());
            }
        }
    }
}
