package com.sparrow;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


@SpringBootApplication(scanBasePackages = {"com.sparrow.*"},exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = "com.sparrow.*",annotationClass = Repository.class)
public class SparrowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparrowApplication.class, args);
	}

}