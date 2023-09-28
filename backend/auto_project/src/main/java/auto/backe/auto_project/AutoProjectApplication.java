package auto.backe.auto_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("auto.backe.auto_project.services")
public class AutoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoProjectApplication.class, args);
    }

    @Configuration
    @EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
    public class SecurityConfig {
    }

}
