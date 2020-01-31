package io.evenX86.github.spring.bean.definition.factory;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created with design-pattern-training
 *
 *{@link User} Bean 的 {@link FactoryBean}的实现
 * @author xuyifei
 * @date 2020-01-31 11:20 下午
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
