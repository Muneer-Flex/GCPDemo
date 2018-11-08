package com.flex.gcp.ExpenseManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is the main class for invoking the Expense Manager App
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@SpringBootApplication
public class ExpenseManagerApp extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExpenseManagerApp.class);
	}
	
    public static void main( String[] args ) {
        SpringApplication.run(ExpenseManagerApp.class, args);
    }
}
