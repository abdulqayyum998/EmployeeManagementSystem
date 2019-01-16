package com.ems.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ems.common.UtilityFunctions;
import com.ems.object.Employee;
import com.ems.rest.objects.FilterOptions;


/**
 * The Class EmployeeService. Employee service for managing all operations save/update/delete etc.
 */
@Service
public class EmployeeService implements EmployeeServiceInterface {

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#saveEmployee(com.ems.object.Employee)
	 */
	@Override
	public Employee saveEmployee(Employee employee) throws Exception {
		FileService.getSingleTonObject().addData(employee);
		return employee;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#updateEmployee(com.ems.object.Employee)
	 */
	@Override
	public Employee updateEmployee(Employee employee) throws FileNotFoundException,  JSONException, IOException, Exception {
		FileService.getSingleTonObject().updateData(employee);
		return employee;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#deleteEmployee(int)
	 */
	@Override
	public Employee deleteEmployee(int empId) throws FileNotFoundException, JSONException, IOException, Exception {
		JSONObject jsonObject=FileService.getSingleTonObject().deleteData(empId);
		Employee emp= new Employee(jsonObject);
		//	emp.getEmployee(jsonObject);
		return emp;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#getEmployeeList()
	 */
	@Override
	public List<Employee> getEmployeeList() throws Exception {
		JSONArray empData=FileService.getSingleTonObject().readAllData();
		List<Employee> employeeList=UtilityFunctions.getEmployeeList(empData);
		return employeeList;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#filterEmployee(com.ems.rest.objects.FilterOptions)
	 */
	@Override
	public List<Employee> filterEmployee(FilterOptions filterOpt) throws Exception {
		JSONArray empData=FileService.getSingleTonObject().readAllData();
		List<Employee> employeeList=UtilityFunctions.getEmployeeList(empData);
		employeeList=UtilityFunctions.filterByAge(filterOpt, employeeList);
		return employeeList;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.EmployeeServiceInterface#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int empId) throws Exception {
		JSONArray empData=FileService.getSingleTonObject().readAllData();
		Employee employee=UtilityFunctions.getEmployee(empData, empId);
		return employee;

	}



}
