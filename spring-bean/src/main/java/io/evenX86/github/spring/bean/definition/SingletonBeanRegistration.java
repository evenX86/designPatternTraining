package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.spring.bean.definition.factory.DefaultUserFactoryImpl;
import io.evenX86.github.spring.bean.definition.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-02-01 5:02 下午
 */
public class SingletonBeanRegistration {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        UserFactory userFactory = new DefaultUserFactoryImpl();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory", userFactory);

        // 启动应用上下文
        applicationContext.refresh();

        UserFactory userFactory1 = beanFactory.getBean("userFactory", UserFactory.class);
        System.out.println(userFactory == userFactory1);


        // 关闭应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文关闭...");

    }
}
