package io.evenX86.github.spring.bean.definition.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2020-01-31 11:10 下午
 */
public class DefaultUserFactoryImpl implements UserFactory, InitializingBean, DisposableBean {

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

    @PreDestroy
    public void preDestroy() {
        System.out.println("pre destroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("disposable destroy");
    }

    @Override
    public void doDestroy() {
        System.out.println("do destroy");
    }

    @Override
    protected void finalize() {
        System.out.println("当前对象正在被回收...");
    }
}
