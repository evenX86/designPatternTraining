package io.evenX86.github.ioc.container;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created with design-pattern-training
 *
 * {@link org.springframework.beans.factory.BeanFactory} 作为IoC容器示例
 * @author xuyifei
 * @date 2020-01-29 4:41 下午
 */
@Configuration
public class ApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置类
        applicationContext.register(ApplicationContextAsIocContainerDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        lookuplist(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("123");
        return user;
    }

    private static void lookuplist(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
        System.out.println(userMap);
    }
}
