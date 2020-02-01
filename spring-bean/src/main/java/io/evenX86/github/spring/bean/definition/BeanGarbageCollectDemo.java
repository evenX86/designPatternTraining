package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.spring.bean.definition.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-02-01 4:53 下午
 */
@Configuration
public class BeanGarbageCollectDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(BeanGarbageCollectDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        System.out.println("Spring 应用上下文已经启动...");
        System.out.println("Spring 应用上下文准备关闭...");
        // 关闭应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文关闭...");



        // 强制执行GC
        System.gc();

        Thread.sleep(5000);

    }
}
