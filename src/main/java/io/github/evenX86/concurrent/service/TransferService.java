package io.github.evenX86.concurrent.service;

import java.util.concurrent.CompletableFuture;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 10:46 AM
 */
public interface TransferService {
    /**
     * 异步转账服务
     * @param fromAccount
     * @param toAccount
     * @param amount
     * @return
     */
    public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount);
}
