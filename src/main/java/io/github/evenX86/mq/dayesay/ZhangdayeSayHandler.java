package io.github.evenX86.mq.dayesay;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static io.github.evenX86.mq.dayesay.DayeCommonsUtil.LI;
import static io.github.evenX86.mq.dayesay.DayeCommonsUtil.ZH;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 5:45 PM
 */
@ChannelHandler.Sharable
public class ZhangdayeSayHandler extends SimpleChannelInboundHandler<Message> {
    public static final ZhangdayeSayHandler INSTANCE = new ZhangdayeSayHandler();
    private int cnt1 = 0;
    private int cnt2 = 0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        if (LI[1].equals(message.getMsg())) {
            cnt1 ++;
            ctx.write(new Message(ZH[1]));
            if (cnt1 % 100 == 0) {
                ctx.flush();
            }
        } else if (LI[2].equals(message.getMsg())) {
            cnt2 ++;
            ctx.write(new Message(ZH[2]));
            if (cnt2 % 100 == 0) {
                ctx.flush();
            }

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("exception cause : " + cause);
        ctx.close();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        new Thread(() -> {
            for (int i=0;i<10000;i++) {
                ctx.write(ZH[0]);
                if (i+1 % 100 == 0) {
                    ctx.flush();
                }
            }
        }).start();

    }

}
