package io.evenX86.github.spring.dependency;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with design-pattern-training
 *
 * 双亲委派查找Bean
 * @author xuyifei
 * @date 2020-02-02 10:38 上午
 */
public class HierarchicalBeanFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        //1 . 获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableBeanFactory


        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        HierarchicalBeanFactory parentFactory = createParentBeanFactory();
        System.out.println("parent factory: " + beanFactory.getParentBeanFactory());

        // 设置parent bean factory
        beanFactory.setParentBeanFactory(parentFactory);
        System.out.println("parent factory: " + beanFactory.getParentBeanFactory());

        // false
        displayLocalBean(beanFactory, "user");
        // true
        displayLocalBean(parentFactory, "user");
        applicationContext.close();
    }


    private static ConfigurableListableBeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:/META-INF/dependcy-lookup.xml");
        return factory;
    }

    private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.println("当前BeanFactory: " + beanFactory + " bean: " + beanName + " 是否包含: " + beanFactory.containsLocalBean(beanName));

    }
}
