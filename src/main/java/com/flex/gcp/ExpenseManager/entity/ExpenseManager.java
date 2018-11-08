/**
 * 
 */
package com.flex.gcp.ExpenseManager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is the entity class that maps on to EXPENSES entity
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
@Entity
@Table(name="EXPENSES")
public class ExpenseManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EXPENSE_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EXPENSE_AMOUNT")
	private String expenseAmount;
	
	@Column(name="EXPENSE_TYPE")
	private String expenseType;
	
	/**
	 * 
	 */
	public ExpenseManager() {
		//Default Constructor
	}

	/**
	 * @param id
	 * @param name
	 * @param expenseAmount
	 * @param expenseType
	 */
	public ExpenseManager(int id, String name, String expenseAmount, String expenseType) {
		super();
		this.id = id;
		this.name = name;
		this.expenseAmount = expenseAmount;
		this.expenseType = expenseType;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the expenseAmount
	 */
	public String getExpenseAmount() {
		return expenseAmount;
	}

	/**
	 * @param expenseAmount the expenseAmount to set
	 */
	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	/**
	 * @return the expenseType
	 */
	public String getExpenseType() {
		return expenseType;
	}

	/**
	 * @param expenseType the expenseType to set
	 */
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExpenseManager [id=" + id + ", name=" + name + ", expenseAmount=" + expenseAmount + ", expenseType="
				+ expenseType + "]";
	}
	
	
}
