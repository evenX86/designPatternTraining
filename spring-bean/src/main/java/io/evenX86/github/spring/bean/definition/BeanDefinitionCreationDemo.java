package io.evenX86.github.spring.bean.definition;

import io.evenX86.github.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created with design-pattern-training
 *
 * 1. BeanDefinitionBuilder
 * 2. AbstractBeanDefinition
 * @author xuyifei
 * @date 2020-01-29 5:35 下午
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1. 通过BeanDefinitionBuilder 创建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id", 1L);
        beanDefinitionBuilder.addPropertyValue("name", "222");

        // 或许 BeanDefinition实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // beanDefinition 并非终态


        // 2. 通过AbstractBeanDefinition 创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过mutablePropertyValues 批量操作
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("id",2L).add("name","33");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);



    }
}
