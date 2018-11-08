/**
 * 
 */
package com.flex.gcp.ExpenseManager.controller;

import static com.flex.gcp.ExpenseManager.utils.AppConstants.CREATE_EXPENSE;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.LIST_EXPENSE_DETAILS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flex.gcp.ExpenseManager.entity.ExpenseManager;
import com.flex.gcp.ExpenseManager.service.ExpenseManagerService;

/**
 * This class acts as the Controller layer for Expense Manager
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@RestController
public class ExpenseManagerController {
	
	@Autowired
	private ExpenseManagerService expenseManagerService;
	
	@RequestMapping(value=LIST_EXPENSE_DETAILS, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ExpenseManager> retrieveExpenseDetails() {

		List<ExpenseManager> expenseMgrList = new ArrayList<>();

		try {
			expenseMgrList = expenseManagerService.retrieveExpenseDetails();

			return expenseMgrList;

		} catch (Exception exception) {
			System.out.println(
					"Exception occured during ExpenseManagerController#retrieveExpenseDetails(). The Exception is: "
							+ exception);
		}

		return expenseMgrList;
	}
	
	@RequestMapping(value=CREATE_EXPENSE, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String createExpenseDetails(@RequestBody ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			status = expenseManagerService.createExpenseDetails(expenseMgrObj);
			
			return status;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured during ExpenseManagerController#createExpenseDetails(). The Exception is: "
							+ exception);
		}

		return status;
	}
}
