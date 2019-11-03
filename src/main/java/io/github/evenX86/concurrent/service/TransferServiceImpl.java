package io.github.evenX86.concurrent.service;

import java.util.concurrent.CompletableFuture;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 10:48 AM
 */
public class TransferServiceImpl implements TransferService {
    private AccountService accountService;

    @Override
    public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
        return accountService.add(fromAccount, -1 * amount)
                .thenCompose(v -> accountService.add(toAccount, amount));
    }
}
