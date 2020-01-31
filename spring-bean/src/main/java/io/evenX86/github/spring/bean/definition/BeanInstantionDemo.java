package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 10:49 下午
 */
public class BeanInstantionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantion-context.xml");

        User user = beanFactory.getBean("user-by-static-method", User.class);
        User user1 = beanFactory.getBean("user-by-instance-method", User.class);
        User user2 = beanFactory.getBean("user-by-factory-method", User.class);

        System.out.println(user == user1);
        System.out.println(user == user2);
    }

}
