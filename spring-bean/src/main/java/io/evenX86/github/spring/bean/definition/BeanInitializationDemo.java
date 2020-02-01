package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import io.evenX86.github.spring.bean.definition.factory.DefaultUserFactoryImpl;
import io.evenX86.github.spring.bean.definition.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created with design-pattern-training
 *
 * Bean 初始化Demo
 * @author xuyifei
 * @date 2020-02-01 1:52 下午
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(BeanInitializationDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);


        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initMaunal")
    public UserFactory userFactory() {
        return new DefaultUserFactoryImpl();
    }
}
