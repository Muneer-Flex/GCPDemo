/**
 * 
 */
package com.flex.gcp.ExpenseManager.dao;

import static com.flex.gcp.ExpenseManager.utils.AppConstants.FAILED;
import static com.flex.gcp.ExpenseManager.utils.AppConstants.SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.flex.gcp.ExpenseManager.entity.ExpenseManager;
import com.flex.gcp.ExpenseManager.utils.HibernateUtils;

/**
 * This class acts as the Data Access Object layer for Expense Manager
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@Repository
public class ExpenseManagerDao {

	Session session = null;

	Query query = null;
	
	@SuppressWarnings("unchecked")
	public List<ExpenseManager> retrieveExpenseDetails() {

		List<ExpenseManager> expenseMgrList = new ArrayList<>();

		try {

			session = HibernateUtils.getSessionFatory().openSession();
			session.getTransaction().begin();

			String hql = "Select expense from ExpenseManager expense order by expense.id";

			query = session.createQuery(hql);

			expenseMgrList = query.list();

			return expenseMgrList;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured in ExpenseManagerDao#retrieveExpenseDetails(). The Exception is: " + exception);
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println(
						"Exception occured while closing session in ExpenseManagerDao#retrieveExpenseDetails(). The Exception is: "
								+ exception);
			}
		}

		return expenseMgrList;
	}
	
	public String createExpenseDetails(ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			session = HibernateUtils.getSessionFatory().openSession();
			session.getTransaction().begin();

			session.save(expenseMgrObj);
			
			session.getTransaction().commit();
			
			status = SUCCESS;

			return status;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured in ExpenseManagerDao#createExpenseDetails(). The Exception is: " + exception);

			status = FAILED;

			return status;
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println(
						"Exception occured while closing session in ExpenseManagerDao#createExpenseDetails(). The Exception is: "
								+ exception);
			}
		}

	}
	
	public String updateExpenseDetails(ExpenseManager expenseMgrObj) {

		String status = null;

		try {
			session = HibernateUtils.getSessionFatory().openSession();
			session.getTransaction().begin();

			session.saveOrUpdate(expenseMgrObj);

			session.getTransaction().commit();

			status = SUCCESS;

			return status;
		} catch (Exception exception) {
			System.out.println(
					"Exception occured in ExpenseManagerDao#updateExpenseDetails(). The Exception is: " + exception);

			status = FAILED;

			return status;
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println(
						"Exception occured while closing session in ExpenseManagerDao#updateExpenseDetails(). The Exception is: "
								+ exception);
			}
		}

	}
	
	public String deleteExpenseDetails(int id) {

		String status = null;

		try {
			session = HibernateUtils.getSessionFatory().openSession();
			session.getTransaction().begin();
			
			String hql = "Delete from ExpenseManager where id = :id ";
			
			query = session.createQuery(hql);
			query.setParameter("id", id);
			
			int result = query.executeUpdate();
			
			return result >=1 ? SUCCESS : FAILED;
			
		} catch (Exception exception) {
			System.out.println(
					"Exception occured in ExpenseManagerDao#deleteExpenseDetails(). The Exception is: " + exception);

			status = FAILED;

			return status;
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception exception) {
				System.out.println(
						"Exception occured while closing session in ExpenseManagerDao#deleteExpenseDetails(). The Exception is: "
								+ exception);
			}
		}
	}
}
