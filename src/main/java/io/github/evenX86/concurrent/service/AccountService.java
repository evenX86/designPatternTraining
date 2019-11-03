package io.github.evenX86.concurrent.service;

import java.util.concurrent.CompletableFuture;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-03 10:50 AM
 */
public interface AccountService {
    CompletableFuture<Void> add(int account, int amount);
}
