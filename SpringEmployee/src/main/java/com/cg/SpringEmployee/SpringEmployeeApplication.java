package com.cg.SpringEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.cg.bean")
@EnableJpaRepositories("com.cg.repo1")
@SpringBootApplication
@ComponentScan("com.cg")
public class SpringEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeApplication.class, args);
	}
}
