package com.spring.mvc.configs;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		AnnotationConfigWebApplicationContext annoCfgWebCtx = new 
		AnnotationConfigWebApplicationContext();
		
		annoCfgWebCtx.register(WebAppConfig.class);
		annoCfgWebCtx.setServletContext(container);
		
		ServletRegistration.Dynamic servlet = 
		container.addServlet("dispatcher", new DispatcherServlet(annoCfgWebCtx));
		
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}