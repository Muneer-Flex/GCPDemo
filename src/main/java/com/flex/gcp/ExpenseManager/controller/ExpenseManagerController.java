/**
 * 
 */
package com.flex.gcp.ExpenseManager.controller;

import static com.flex.gcp.ExpenseManager.utils.AppConstants.CREATE_EXPENSE_DETAILS;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.DELETE_EXPENSE_DETAILS;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.HTTP_FORBIDDEN;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.HTTP_NOT_FOUND;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.HTTP_OK;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.HTTP_UNAUTHORIZED;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.LIST_EXPENSE_DETAILS;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.UPDATE_EXPENSE_DETAILS;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flex.gcp.ExpenseManager.entity.ExpenseManager;
import com.flex.gcp.ExpenseManager.service.ExpenseManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class acts as the Controller layer for Expense Manager
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@RestController
@Api(value="Expense Manager")
public class ExpenseManagerController {
	
	@Autowired
	private ExpenseManagerService expenseManagerService;
	
	@ApiOperation(value="List Expense Details", notes="This API is used to retrieve all the expense details from DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
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
	
	@ApiOperation(value="Create Expense Details", notes="This API is used to create & save an expense record into DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=CREATE_EXPENSE_DETAILS, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
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
	
	@ApiOperation(value="Update Expense Details", notes="This API is used to update the expense details into DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=UPDATE_EXPENSE_DETAILS, method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String updateExpenseDetails(@RequestBody ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			status = expenseManagerService.updateExpenseDetails(expenseMgrObj);

			return status;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured during ExpenseManagerController#updateExpenseDetails(). The Exception is: "
							+ exception);
		}

		return status;
	}
	
	@ApiOperation(value="Delete Expense Details", notes="This API is used to delete the expense details from DB")
	@ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = HTTP_OK),
            @ApiResponse(code = HttpStatus.SC_UNAUTHORIZED, message = HTTP_UNAUTHORIZED),
            @ApiResponse(code = HttpStatus.SC_FORBIDDEN, message = HTTP_FORBIDDEN),
            @ApiResponse(code = HttpStatus.SC_NOT_FOUND, message = HTTP_NOT_FOUND) })
	@RequestMapping(value=DELETE_EXPENSE_DETAILS, method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String deleteExpenseDetails(@RequestParam int id) {

		String status = null;

		try {
			status = expenseManagerService.deleteExpenseDetails(id);

			return status;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured during ExpenseManagerController#deleteExpenseDetails(). The Exception is: "
							+ exception);
		}

		return status;
	}
}
