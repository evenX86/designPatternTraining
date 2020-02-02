package io.evenX86.github.spring.dependency;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with design-pattern-training
 *
 * 类型安全依赖查找示例
 * @author xuyifei
 * @date 2020-02-02 8:37 下午
 */
public class TypeSafeDependencyLookUpDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        //1 . 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableBeanFactory

        displayGetBean(applicationContext);

        displayObjectFactoryBean(applicationContext);

        displayObjectProviderBean(applicationContext);

        displayListableBean(applicationContext);

        applicationContext.close();
    }

    // 类型不安全
    public static void displayGetBean(BeanFactory beanFactory) {
        displayException("displayGetBean", () -> beanFactory.getBean(User.class));
    }


    // 类型不安全
    public static void displayObjectFactoryBean(AnnotationConfigApplicationContext applicationContext) {
        ObjectFactory<User> objectFactory = applicationContext.getBeanProvider(User.class);
        displayException("displayObjectFactoryBean ", () -> System.out.println(objectFactory.getObject()));
    }


    public static void displayObjectProviderBean(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectFactory = applicationContext.getBeanProvider(User.class);
        displayException("displayObjectProviderBean ", () -> System.out.println(objectFactory.getIfAvailable()));
    }

    public static void displayListableBean(ListableBeanFactory beanFactory) {
        displayException("displayObjectProviderBean ", () -> System.out.println(beanFactory.getBeansOfType(User.class)));
    }


    public static void displayException(String source, Runnable runnable){
        System.err.println(source);
        try {
            runnable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
