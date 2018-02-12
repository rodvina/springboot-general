package com.ro.springboot.lookupmethodinjection;

import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages="com.ro.springboot.lookupmethodinjection")
@EnableScheduling
public class SpringbootBeanconfigApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBeanconfigApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Service service) {
		return(args) -> {
			IntStream.range(0, 5).forEach(i -> {
						service.processTransaction(UUID.randomUUID().toString());
					});

		};
	}
	
	
}
