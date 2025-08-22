package com.trustscore.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(
    scanBasePackages = "com.trustscore.backend",
    exclude = { SecurityAutoConfiguration.class }  // 🚨 disables default Spring Security
)
@EnableMongoRepositories(basePackages = "com.trustscore.backend.repository")
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    // Debugging: Print important beans to confirm they load
    @Bean
    public CommandLineRunner printBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("===== Loaded Spring Beans =====");
            String[] beans = ctx.getBeanDefinitionNames();
            for (String bean : beans) {
                if (bean.toLowerCase().contains("trust") || bean.toLowerCase().contains("loan") || bean.toLowerCase().contains("security")) {
                    System.out.println("✅ " + bean);
                }
            }
            System.out.println("================================");
        };
    }
}
