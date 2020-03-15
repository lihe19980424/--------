package com.neusoft.neuedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neusoft.neuedu.dao")
public class NeueduApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeueduApplication.class, args);
	}

}
