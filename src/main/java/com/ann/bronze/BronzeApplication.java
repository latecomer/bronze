package com.ann.bronze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
public class BronzeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BronzeApplication.class, args);
	}

}
