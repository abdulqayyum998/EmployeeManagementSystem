package com.ems.common;

import java.util.List;

import com.ems.object.Employee;
import com.ems.rest.objects.ResponseStatus;


/**
 * The Class Response. This class represents basically the response returned
 * from each rest call. It contains following three key attributes.
 * 1) Response Status - Response status for each rest call processing.
 * 2) Error Message - In case of error for rest call this will be error message
 * 						returned by server.
 * 3) Employee List - For all rest calls where there would be some returning data then
 * 						this variable will contain all returned employees list. 
 */
// M1
public class Response {
	
	/** The response status. */
	private ResponseStatus responseStatus=ResponseStatus.NONE;
	
	/** The error message. */
	private String errorMessage="";
	
	/** The emp list. */
	private List<Employee> empList;
	
	/**
	 * Gets the response status.
	 *
	 * @return the response status
	 */
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	
	/**
	 * Sets the response status.
	 *
	 * @param responseStatus the new response status
	 */
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/**
	 * Gets the emp list.
	 *
	 * @return the emp list
	 */
	public List<Employee> getEmpList() {
		return empList;
	}
	
	/**
	 * Sets the emp list.
	 *
	 * @param empList the new emp list
	 */
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
