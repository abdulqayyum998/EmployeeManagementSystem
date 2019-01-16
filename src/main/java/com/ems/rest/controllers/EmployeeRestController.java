package com.ems.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.common.Response;
import com.ems.object.Employee;
import com.ems.rest.objects.FilterOptions;
import com.ems.rest.objects.ResponseStatus;
import com.ems.service.EmployeeService;


/**
 * The Class EmployeeRestController. This is rest controller exposes all rest end points to the
 * outer world to manage all operations related to employee management.
 */
@RestController
@RequestMapping("employee")
public class EmployeeRestController {
	
	/** The emp service. */
	@Autowired
	private EmployeeService empService;

	/**
	 * This rest method returns all employees from the database. 
	 *
	 * @return the response object containing status, error message and output employee list.
	 */
	@GetMapping(value="/all")
	public Response getAll(){
		Response response= new Response();
		try {
			List<Employee> list=empService.getEmployeeList();
			response.setEmpList(list);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response;

	}

	/**
	 * Gets the employee by id. This method return employee for given employee id.
	 *
	 * @param id the id
	 * @return the response object containing status, error message and output employee list.
	 */
	@GetMapping(value="/{id}")
	public Response getEmployeeById(@PathVariable String id){


		Response response= new Response();
		List<Employee> empList= new ArrayList<Employee>();
		try {
			Employee emp=empService.getEmployeeById(Integer.valueOf(id));
			empList.add(emp);
			response.setEmpList(empList);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response;
	}

	/**
	 * Adds the employee. This function add new employee to the json file database.
	 *
	 * @param emp the emp
	 * @return the response object containing status, error message and output employee list.
	 */
	@PostMapping(value="/add")
	public Response addEmployee(@RequestBody Employee emp){

		Response response= new Response();
		List<Employee> empList= new ArrayList<Employee>();
		try {
			empService.saveEmployee(emp);
			empList.add(emp);
			response.setEmpList(empList);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response;
	}

	/**
	 * Update employee. This function update employee based upon given employee.
	 *
	 * @param emp the emp
	 * @return the response object containing status, error message and output employee list.
	 */
	@PostMapping(value="/update")
	public Response updateEmployee(@RequestBody Employee emp){

		Response response= new Response();
		List<Employee> empList= new ArrayList<Employee>();
		try {
			empService.updateEmployee(emp);
			empList.add(emp);
			response.setEmpList(empList);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response; 
	}

	/**
	 * Delete employee. This function delete the employee from json file database based on given
	 * employee id.
	 *
	 * @param id the id
	 * @return the response object containing status, error message and output employee list.
	 */
	@PostMapping(value="/delete/{id}")
	public Response deleteEmployee(@PathVariable String id){

		Response response= new Response();
		List<Employee> empList= new ArrayList<Employee>();
		try {
			empService.deleteEmployee(Integer.valueOf(id));
			response.setEmpList(empList);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response; 
	}

	/**
	 * Filter employee by age. This function returns employee list based on given filter options.
	 *
	 * @param filterOptions the filter options
	 * @return the response object containing status, error message and output employee list.
	 */
	@PostMapping(value="/filterbyage")
	public Response filterEmployeeByAge(@RequestBody FilterOptions filterOptions){

		Response response= new Response();
		List<Employee> empList= new ArrayList<Employee>();
		try {
			empList=empService.filterEmployee(filterOptions);
			response.setEmpList(empList);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception ex) {
			ex.printStackTrace();
			response.setResponseStatus(ResponseStatus.FAILED);
			response.setErrorMessage(ex.getMessage());
		}

		return response;  
	}
}
