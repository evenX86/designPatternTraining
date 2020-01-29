package io.evenX86.github.ioc.container;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created with design-pattern-training
 *
 * BeanFactory 是Spring 底层IoC的容器
 * ApplicationContext是具备应用特性的BeanFactory的超集
 * @author xuyifei
 * @date 2020-01-29 4:34 下午
 */
public class IocContainerDemo {

    public static void main(String[] args) {
        // 创建beanfactory 容器
        //
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int count = reader.loadBeanDefinitions("classpath:/META-INF/dependcy-lookup.xml");

        System.out.println(count);

        lookuplist(factory);


    }


    private static void lookuplist(BeanFactory beanFactory) {
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
        System.out.println(userMap);
    }
}
