package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with design-pattern-training
 *
 * 1. BeanDefinitionBuilder
 * 2. AbstractBeanDefinition
 * @author xuyifei
 * @date 2020-01-29 5:35 下午
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependcy-context.xml");

        User user = beanFactory.getBean("user-alias", User.class);
        User user1 = beanFactory.getBean("user", User.class);

        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user);



    }
}
