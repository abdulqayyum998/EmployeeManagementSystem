package com.ems.object;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.ems.common.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Employee. This is main object domain class for all processing.
 */
@Component
public class Employee {

	/** The id. Employee id which uniquely identify it in system.*/
	private int id;
	
	/** The full name. */
	private String fullName;
	
	/** The age. */
	private double age;
	
	/** The salary. */
	private double salary;
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
		id=0;
		fullName="";
		age=0;
		salary=0;
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param id the id
	 * @param fullName the full name
	 * @param age the age
	 * @param salary the salary
	 */
	public Employee(int id,String fullName,double age,double salary) {
		this.id=id;
		this.fullName=fullName;
		this.age=age;
		this.salary=salary;
	}

	/**
	 * Instantiates a new employee for given json employee object.
	 *
	 * @param jsonObj the json obj representing employee.
	 */
	public Employee(JSONObject jsonObj) {
		this.id=jsonObj.getInt(Constants.EMPLOYEE_ID);
		this.fullName=jsonObj.getString(Constants.EMPLOYEE_NAME);
		this.age=jsonObj.getDouble(Constants.EMPLOYEE_AGE);
		this.salary=jsonObj.getDouble(Constants.EMPLOYEE_SALARY);
	}

	/**
	 * Gets the json. 
	 *
	 * @return the json from current employee object.
	 * @throws JSONException the JSON exception
	 */
	@JsonIgnore
	public JSONObject getJson() throws JSONException {
		JSONObject empJsonObj= new JSONObject();
		empJsonObj.put(Constants.EMPLOYEE_ID, id);
		empJsonObj.put(Constants.EMPLOYEE_NAME, fullName);
		empJsonObj.put(Constants.EMPLOYEE_AGE, age);
		empJsonObj.put(Constants.EMPLOYEE_SALARY, salary);
		return empJsonObj;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public double getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(double age) {
		this.age = age;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
