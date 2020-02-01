package io.evenX86.github.ioc.domain;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-20 9:36 下午
 */
public class User {
    private Long id;
    private String name;

    public static User createUser() {
        return new User();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
