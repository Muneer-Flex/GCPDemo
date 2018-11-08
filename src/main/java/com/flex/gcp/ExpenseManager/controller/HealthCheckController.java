/**
 * 
 */
package com.flex.gcp.ExpenseManager.controller;

import static com.flex.gcp.ExpenseManager.utils.AppConstants.APP;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.HEALTH_CHECK;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author gssmunej
 *
 */
@RestController
@PropertySource("classpath:application.properties")
@RequestMapping(APP)
public class HealthCheckController {

	@Value("${appName}")
	private String appName;
	
	@Value("${appVersion}")
	private String appVersion;
	
	@RequestMapping(value=HEALTH_CHECK, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String healthCheck() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("App Name is: "+appName);
		sb.append(System.lineSeparator());
		sb.append("App Version is: "+appVersion);
		sb.append(System.lineSeparator());
		sb.append(appName+ " is Up & running fine!");
		
		return sb.toString();
	}
}
