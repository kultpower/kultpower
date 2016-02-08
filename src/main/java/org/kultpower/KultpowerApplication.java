package org.kultpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"org.kultpower", "org.kultpower.controller", "org.kultpower.service", "org.kultpower.application", "org.kultpower.entities"})
@SpringBootApplication(scanBasePackages = "org.kultpower")
@EnableJpaRepositories({"org.kultpower", "org.kultpower.entities"})
@EntityScan(basePackages = "org.kultpower.entities")
public class KultpowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KultpowerApplication.class, args);
	}
}
