package com.packaging.warpackaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rahul mehta
 *
 */
@ComponentScan({ "controller" })
@SpringBootApplication
public class SpringBootPackagingExampleApplication extends SpringBootServletInitializer {

	/**
	 * Used when application is packaged as a JAR
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPackagingExampleApplication.class, args);
	}

	/**
	 * Used when application is packaged as a WAR. Application can be deployed to any other servlet container.
	 *
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootPackagingExampleApplication.class);
	}
}