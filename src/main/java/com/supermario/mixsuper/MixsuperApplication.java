package com.supermario.mixsuper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.supermario.mixsuper.mapper")
public class MixsuperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixsuperApplication.class, args);
	}
}
