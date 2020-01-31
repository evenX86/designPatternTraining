package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.container.ApplicationContextAsIocContainerDemo;
import io.evenX86.github.ioc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-29 10:07 下午
 */
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(Config.class);

        // 启动应用上下文
        applicationContext.refresh();


        // 关闭应用上下文
        applicationContext.close();
    }

    public static class Config {
        @Bean(name = {"user", "xuyifei"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("123");
            return user;
        }
    }


}
