package io.evenX86.github.spring.bean.definition.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 11:10 下午
 */
public class DefaultUserFactoryImpl implements UserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("1 post construct init...");
    }

    @Override
    public void initMaunal() {
        System.out.println("3 manual init...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2 afterPropertiesSet init...");

    }
}
