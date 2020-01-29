package io.evenX86.github.ioc.repository;

import io.evenX86.github.ioc.domain.User;

import java.util.Collection;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-23 9:58 上午
 */
public class UserRepository {
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
