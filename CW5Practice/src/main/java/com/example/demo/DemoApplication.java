package com.example.demo;

import java.util.List;

import com.example.demo.model.CurrencyExchangeShort;
import com.example.demo.repository.CurrencyExchangeShortRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDb(CurrencyExchangeShortRepository repository) {
		return args -> {
			repository.saveAll(List.of(
					new CurrencyExchangeShort(1, 100.0, "USD"),
					new CurrencyExchangeShort(2, 10.0, "BLR"),
					new CurrencyExchangeShort(3, 50.0, "JPY")
			));
		};
	}
}
