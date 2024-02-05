package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("minwoo",10000);
        statefulService2.order("minjeong",5000);

        int price = statefulService1.getPrice();
        //박민우는 10000원을 기대했지만 5000원 출력.
        System.out.println("price = "+price);

        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(5000);
    }


    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}