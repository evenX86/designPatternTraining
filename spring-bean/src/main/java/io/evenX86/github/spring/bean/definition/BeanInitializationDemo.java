package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import io.evenX86.github.spring.bean.definition.factory.DefaultUserFactoryImpl;
import io.evenX86.github.spring.bean.definition.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * Created with design-pattern-training
 *
 * Bean 初始化Demo
 * @author xuyifei
 * @date 2020-02-01 1:52 下午
 */
public class BeanInitializationDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(BeanInitializationDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        System.out.println("Spring 应用上下文已经启动...");

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        System.out.println(userFactory);

        System.out.println("Spring 应用上下文准备关闭...");
        // 关闭应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文关闭...");

        System.gc();

        Thread.sleep(5000);
    }

    @Lazy(false)
    @Bean(initMethod = "initMaunal", destroyMethod = "doDestroy")
    public UserFactory userFactory() {
        return new DefaultUserFactoryImpl();
    }
}
