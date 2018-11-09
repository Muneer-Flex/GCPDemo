/**
 * 
 */
package com.flex.gcp.ExpenseManager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flex.gcp.ExpenseManager.dao.ExpenseManagerDao;
import com.flex.gcp.ExpenseManager.entity.ExpenseManager;

/**
 * This class acts as the Service layer for Expense Manager
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@Service
public class ExpenseManagerService {
	
	@Autowired
	private ExpenseManagerDao expenseManagerDao;
	
	public List<ExpenseManager> retrieveExpenseDetails() {

		List<ExpenseManager> expenseMgrList = new ArrayList<>();

		try {
			expenseMgrList = expenseManagerDao.retrieveExpenseDetails();

			return expenseMgrList;
		} catch (Exception exception) {
			System.out.println("Exception occured in ExpenseManagerService#retrieveExpenseDetails(). The Exception is: "
					+ exception);
		}

		return expenseMgrList;
	}
	
	public String createExpenseDetails(ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			status = expenseManagerDao.createExpenseDetails(expenseMgrObj);

			return status;
		} catch (Exception exception) {
			System.out.println("Exception occured in ExpenseManagerService#createExpenseDetails(). The Exception is: "
					+ exception);
		}

		return status;
	}
	
	public String updateExpenseDetails(ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			status = expenseManagerDao.updateExpenseDetails(expenseMgrObj);

			return status;
		} catch (Exception exception) {
			System.out.println("Exception occured in ExpenseManagerService#updateExpenseDetails(). The Exception is: "
					+ exception);
		}

		return status;
	}
	
	public String deleteExpenseDetails(int id) {

		String status = null;

		try {
			status = expenseManagerDao.deleteExpenseDetails(id);

			return status;
		} catch (Exception exception) {
			System.out.println("Exception occured in ExpenseManagerService#deleteExpenseDetails(). The Exception is: "
					+ exception);
		}

		return status;
	}
}
