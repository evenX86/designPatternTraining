package io.evenX86.github.spring.dependency;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Created with design-pattern-training
 *
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 * @author xuyifei
 * @date 2020-02-01 11:02 下午
 */
public class ObjectProviderDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);

        lookUpIfAvailable(applicationContext);


        lookUpByStream(applicationContext);

        applicationContext.close();
    }
    @Bean
    @Primary
    public String helloWorld() {
        // 方法名就是bean的名称
        return "helloWorld";
    }


    @Bean
    public String message() {
        // 方法名就是bean的名称
        return "message";
    }


    public static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }


    public static void lookUpIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        // 如果上下文中没有User对象，则兜底创建一个
        User user = objectProvider.getIfAvailable(User::createUser);
        System.out.println("当前user对象： " + user);
    }

    public static void lookUpByStream(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        objectProvider.stream().forEach(System.out::println);
    }
}
