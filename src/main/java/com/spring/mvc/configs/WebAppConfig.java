package com.spring.mvc.configs;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.spring.mvc.validations.validators.EmployeeValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.mvc")
@PropertySource("classpath:messages.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new
			InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource messageSource =  
		new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
	 @Bean
	 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	 }	 
	
	/*
	 * enabling JSR-303 validation annotation to access the message from
	 * resource bundle message source using property key of our choice
	 */
	 @Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new
		LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	/*
	 * enabling JSR-303 validation annotation to access the message from
	 * resource bundle message soruce using property key of our choice
	 */
	public Validator getValidator() {
		return validator();
	}
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	@Bean(name = "employeeValidator")
	public Validator employeeValidator() {
		Validator employeeValidator = new EmployeeValidator();
		return employeeValidator;
	}
	
	/**
	 * Internationalization
	 * you should give provide localeResolver name. 
	 */
	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.US);
		return cookieLocaleResolver;
	}
	
	
	@Bean
	public ResourceBundleThemeSource themeSource() {
		ResourceBundleThemeSource resourceBundleThemeSource = new ResourceBundleThemeSource();
		resourceBundleThemeSource.setBasenamePrefix("theme-");
		return resourceBundleThemeSource;
	}
	
	/*
	 * Theme Resolver
	 */
	@Bean
	public CookieThemeResolver themeResolver() {
		CookieThemeResolver cookieThemeResolver =  new CookieThemeResolver();
		cookieThemeResolver.setDefaultThemeName("default");
		return cookieThemeResolver;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
	 
		/**
		 * Locale Interceptor	
		 */
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		interceptorRegistry.addInterceptor(localeChangeInterceptor);
	 
		/**
		 * Theme Interceptor	
		 */
		ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
		themeChangeInterceptor.setParamName("currentTheme");
		interceptorRegistry.addInterceptor(themeChangeInterceptor);
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	/**
	 * Multipart file upload
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new
		CommonsMultipartResolver();
		
		return multipartResolver;
		
		
	}
	
}
