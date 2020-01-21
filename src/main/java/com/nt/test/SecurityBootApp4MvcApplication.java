package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

@SpringBootApplication
@Import({WebMVCAppConfig.class,RootAppConfig.class})
public class SecurityBootApp4MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityBootApp4MvcApplication.class, args);
	}

}
