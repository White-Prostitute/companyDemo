package processor;

import demo.A;
import demo.C;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private C c;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition definition = configurableListableBeanFactory.getBeanDefinition("b");
        System.out.println(definition.getBeanClassName());
        definition.setBeanClassName("demo.A");
    }


    public void setC(C c) {
        this.c = c;
    }
}
