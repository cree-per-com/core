package hello.core.beanfind;

import hello.core.AppConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Target;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출략")
    public void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = "+ beanDefinitionName + "object = "+ bean);
        }
    }
    @Test
    @DisplayName("애플리캐이션 빈 출력")
    public void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+ beanDefinitionName + "object = "+ bean);
            }
        }
    }

}
