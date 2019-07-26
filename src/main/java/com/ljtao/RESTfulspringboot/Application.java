package com.ljtao.RESTfulspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
扫描当下包文件与子包
 */
@SpringBootApplication
@MapperScan("com.ljtao.RESTfulspringboot.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

