/**
 * 
 */
package com.flex.gcp.ExpenseManager.utils;

/**
 * This class is for maintaining the App Constants
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
public class AppConstants {
	
	private AppConstants() {
		//Default Constructor
	}
	
	//API Constants
	public static final String APP = "/App";
	
	public static final String HEALTH_CHECK = "/healthCheck";
	
	public static final String LIST_EXPENSE_DETAILS = "/listExpenseDetails";
	
	public static final String CREATE_EXPENSE_DETAILS = "/createExpenseDetails";
	
	public static final String UPDATE_EXPENSE_DETAILS = "/updateExpenseDetails";
	
	public static final String DELETE_EXPENSE_DETAILS = "/deleteExpenseDetails";
	
	//Result Constants
	public static final String SUCCESS = "SUCCESS";
	
	public static final String FAILED = "FAILED";
	
	//Swagger Constants
	public static final String SWAGGER_URL = "swagger-ui.html";
	
	public static final String APP_TITLE = "EXPENSE MANAGEMENT";
	
	public static final String VERSION = "1.0.0";
	
	public static final String APP_NAME = "Expense-Management";
	
	public static final String ABOUT = "https://flex.com/about/";
	
	public static final String CONTACT_EMAIL = "MuneerAhmed.J@Flex.com";
	
	//Http Client Constants
	public static final String HTTP_OK = "Success|OK";
	
	public static final String HTTP_UNAUTHORIZED = "Not Authorized";
	
	public static final String HTTP_FORBIDDEN = "Forbidden";
	
	public static final String HTTP_NOT_FOUND = "Not Found";
}
