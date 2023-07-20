package demo;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class A implements EnvironmentAware {

    private B b;

    private Environment environment;

    public void setB(B b) {
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public B getB() {
        return b;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
