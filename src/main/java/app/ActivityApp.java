package app;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author joker
 * @date 2019/1/21 10:24
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivityApp {
    public static void main (String[] args){
        SpringApplication.run(ActivityApp.class, args);
    }
}
