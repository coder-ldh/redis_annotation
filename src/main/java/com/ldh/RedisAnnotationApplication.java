package com.ldh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: ldh
 */
@SpringBootApplication
@MapperScan("com.ldh.dao*")
public class RedisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAnnotationApplication.class, args);
	}
}
