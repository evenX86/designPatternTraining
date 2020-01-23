package io.evenX86.github.ioc.overview;

import io.evenX86.github.ioc.annotation.Super;
import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-17 9:54 下午
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {
        lookbyannotation();
    }

    private static void lookuplist() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependcy-lookup.xml");
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
        System.out.println(userMap);
    }

    // 实时查找
    private static void lookuprealtime() {
        // 配置XML配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependcy-lookup.xml");
        User user = (User) beanFactory.getBean("user");
    }

    private static void lookbytype() {
        // 配置XML配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependcy-lookup.xml");
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    private static void lookbyannotation() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependcy-lookup.xml");
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, Object> userMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println(userMap);
    }
    /**
     *
     * 延迟查找
     */
    private static void lookuplazy() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependcy-lookup.xml");
        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = userObjectFactory.getObject();
        System.out.println(user);
    }
}
