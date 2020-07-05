package com.magic.www.permissions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@MapperScan("com.magic.www.permissions.mapper")
public class PermissionsApplication implements ErrorPageRegistrar {

	public static void main(String[] args) {
		SpringApplication.run(PermissionsApplication.class, args);
	}

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		//1、按错误的类型显示错误的网页
		//错误类型为404，找不到网页的，默认显示404.html网页
		ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
		//错误类型为500，表示服务器响应错误，默认显示500.html网页
		ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
		registry.addErrorPages(e404, e500);
	}
}
