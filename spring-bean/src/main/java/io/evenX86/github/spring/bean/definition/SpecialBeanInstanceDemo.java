package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import io.evenX86.github.spring.bean.definition.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 11:29 下午
 */
public class SpecialBeanInstanceDemo {

    public static void main(String[] args) {
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantion-context.xml");

        demoServiceLoader();

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> loader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());

        Iterator<UserFactory> iterator = loader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
