package com.ems.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.ems.object.Employee;
import com.ems.rest.objects.FilterOptions;


/**
 * The Interface EmployeeServiceInterface. Employee Service Interface define contract for all operations
 * required to manage employee management system operations like save, update, delete, filter etc.
 */
@Service
public interface EmployeeServiceInterface {

	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 * @throws Exception the exception
	 */
	public Employee saveEmployee(Employee employee) throws  Exception;
	
	/**
	 * Update employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public Employee updateEmployee(Employee employee) throws FileNotFoundException, JSONException, IOException, Exception;
	
	/**
	 * Delete employee.
	 *
	 * @param empId the emp id
	 * @return the employee
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public Employee deleteEmployee(int empId) throws FileNotFoundException,  JSONException, IOException, Exception;
	
	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 * @throws Exception the exception
	 */
	public List<Employee> getEmployeeList() throws Exception;
	
	/**
	 * Filter employee.
	 *
	 * @param filterOpt the filter opt
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Employee> filterEmployee(FilterOptions filterOpt) throws Exception;
	
	/**
	 * Gets the employee by id.
	 *
	 * @param empId the emp id
	 * @return the employee by id
	 * @throws Exception the exception
	 */
	public Employee getEmployeeById(int empId) throws Exception;
}
