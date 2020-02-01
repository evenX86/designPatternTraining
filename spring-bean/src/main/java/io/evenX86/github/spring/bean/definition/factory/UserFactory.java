package io.evenX86.github.spring.bean.definition.factory;

import io.evenX86.github.ioc.domain.User;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 11:10 下午
 */
public interface UserFactory {

    public default User createUser() {
        return User.createUser();
    }

    void initMaunal();
}
