package com.spacey.springboot;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * Sources: JavaBrains and JavaTPoint
 * | Topic = java
 *   | Course = java-streams
 *     | Lesson = ...
 * @author Night King
 *
 */
@SpringBootApplication
public class AppClient {

	public static void main(String[] args) {
		SpringApplication.run(AppClient.class, args);
	}

	// configuring default locale
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// configuring ResourceBundle
	// 1st way:
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
	// 2nd way: Add the following to the application.properties file
//	spring.messages.basename=messages
}
