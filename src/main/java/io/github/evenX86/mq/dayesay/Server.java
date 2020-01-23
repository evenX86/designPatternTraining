package io.github.evenX86.mq.dayesay;

/**
 * Created with design-pattern-training
 *
 * 两大爷胡同口对话
 * 练习，异步双工
 * 原文地址
 * https://time.geekbang.org/column/article/119988
 * 参考
 * https://github.com/qingzhou413/geektime-mq-rpc
 * @author xuyifei
 * @date 2019-11-03 6:17 PM
 */
public class Server {
    public static void main(String[] args) {
        ZhangdayeSayServerService zhangdayeSayServerService = new ZhangdayeSayServerService();
        LidayeSayClient lidayeSayClient = new LidayeSayClient();
        zhangdayeSayServerService.say();
        lidayeSayClient.say();
    }
}
