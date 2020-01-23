package io.github.evenX86.concurrent.service;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-30 6:22 PM
 */
public class Client {
    private TransferService transferService;

    private final static int A = 1000;
    private final static int B = 1001;

    public void syncInvoke() throws ExecutionException, InterruptedException {
        // 同步调用
        transferService = new TransferServiceImpl();
        transferService.transfer(A, B, 100).get();
        System.out.println("转账完成！");
    }

    public void asyncInvoke() {
        // 异步调用
        transferService.transfer(A, B, 100)
                .thenRun(() -> System.out.println("转账完成！"));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Client client = new Client();
        client.syncInvoke();
    }
}
