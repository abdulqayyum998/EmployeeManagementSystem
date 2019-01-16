package com.ems.rest.objects;

import org.springframework.stereotype.Component;


/**
 * The Class FilterOptions. Filter options to filter employees.
 */
@Component
public class FilterOptions {
	
	/** The operator. */
	private String operator;
	
	/** The value. */
	private int value;
	
	/** The sort. */
	private String sort;
	
	/**
	 * Instantiates a new filter options.
	 */
	public FilterOptions() {

	}
	
	/**
	 * Instantiates a new filter options.
	 *
	 * @param operator the operator
	 * @param value the value
	 * @param sort the sort
	 */
	public FilterOptions(String operator,int value,String sort) {
		this.operator=operator;
		this.value=value;
		this.sort=sort;

	}
	
	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Gets the sort.
	 *
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	
	/**
	 * Sets the sort.
	 *
	 * @param sort the new sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

}
