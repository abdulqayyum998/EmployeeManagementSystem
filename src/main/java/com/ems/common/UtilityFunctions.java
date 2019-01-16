package com.ems.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ems.object.Employee;
import com.ems.rest.objects.FilterOptions;


/**
 * The Class UtilityFunctions. This class contains utility functions used at all layers
 *  of application.
 */
public class UtilityFunctions {

	/**
	 * Gets the employee. This function returns employee object for given employee id 
	 *  from given employee json array.
	 *
	 * @param empJsonArray the emp json array
	 * @param empId the emp id
	 * @return the employee
	 * @throws JSONException the JSON exception
	 */
	public static Employee getEmployee(JSONArray empJsonArray, int empId) throws JSONException {
		JSONObject jsonObj=null;
		Employee emp=null;
		for (int index=0;index<empJsonArray.length();index++) {
			jsonObj=empJsonArray.getJSONObject(index);
			if (jsonObj.getInt(Constants.EMPLOYEE_ID)==empId) {
				break;
			}
		}
		if (jsonObj!=null) {
			emp= new Employee(jsonObj);
			//emp.getEmployee(jsonObj);
		}
		return emp;
	}

	/**
	 * Gets the employee list. This function converts the given json employee array to
	 *  java List of employees.
	 *
	 * @param empJsonArray the emp json array
	 * @return the employee list
	 * @throws JSONException the JSON exception
	 */
	public static List<Employee> getEmployeeList(JSONArray empJsonArray) throws JSONException {
		JSONObject jsonObj=null;
		Employee emp=null;
		List<Employee> employeeList= new ArrayList<Employee>();
		for (int index=0;index<empJsonArray.length();index++) {
			jsonObj=empJsonArray.getJSONObject(index);
			emp= new Employee(jsonObj);
			//emp.getEmployee(jsonObj);
			employeeList.add(emp);

		}
		return employeeList;
	}

	/**
	 * Filter by age.This function returns List of employees based on given filter options and given
	 * employee list.
	 *
	 * @param filterOptions the filter options
	 * @param empList the emp list
	 * @return the list
	 */
	public static List<Employee> filterByAge(FilterOptions filterOptions, List<Employee> empList){
		List<Employee> outList= new ArrayList<Employee>(); 
		Stream<Employee> empStream= empList.stream();
		switch (filterOptions.getOperator()) {
		case "lt":
			empStream=empStream.filter(p -> p.getAge()<filterOptions.getValue());
			break;
		case "lte":
			empStream=empStream.filter(p -> p.getAge()<=filterOptions.getValue());
			break;	
		case "gt":
			empStream=empStream.filter(p -> p.getAge()>filterOptions.getValue());
			break;
		case "gte":
			empStream=empStream.filter(p -> p.getAge()>=filterOptions.getValue());
			break;
		case "eq":
			empStream=empStream.filter(p -> p.getAge()==filterOptions.getValue());
			break;
		case "ne":
			empStream=empStream.filter(p -> p.getAge()!=filterOptions.getValue());
			break;
		}
		if (filterOptions.getSort().equalsIgnoreCase("asc")) {
			empStream=empStream.sorted(Comparator.comparing(Employee::getAge));
		} else if (filterOptions.getSort().equalsIgnoreCase("desc")) {
			empStream=empStream.sorted(Comparator.comparing(Employee::getAge).reversed());
		}

		outList=empStream.collect(Collectors.toCollection(ArrayList::new));
		return outList;
	}

	/**
	 * Read json file. This function reads the given json file and return its whole text as String. 
	 *
	 * @param filePath the file path
	 * @return the string
	 */
	public static String readJsonFile(String filePath) {
		String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return jsonData;
	}
}
