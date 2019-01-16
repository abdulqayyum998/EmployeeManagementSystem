package com.ems.service;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ems.common.Constants;
import com.ems.common.UtilityFunctions;
import com.ems.object.Employee;
import com.ems.rest.objects.FileStatus;


/**
 * The Class FileService. This class provides abstract class implementation for json file read/write/update
 *  operations.
 */
public class FileService extends AbstractFileService {
	
	/** The file service. */
	private static AbstractFileService fileService= new FileService();

	/**
	 * Instantiates a new file service.
	 */
	private FileService() {
	}

	/**
	 * Gets the single ton object.
	 *
	 * @return the single ton object
	 */
	public static AbstractFileService getSingleTonObject() {
		return fileService;
	}


	/* (non-Javadoc)
	 * @see com.ems.service.AbstractFileService#readAllData()
	 */
	@Override
	public JSONArray readAllData() throws Exception {
		JSONArray employeeList= readData();
		return employeeList;
	}

	/* (non-Javadoc)
	 * @see com.ems.service.AbstractFileService#addData(com.ems.object.Employee)
	 */
	@Override
	public synchronized void  addData(Employee emp) throws Exception {
		JSONArray employeeList= readData();
		int newEmpId=getMaxId(employeeList)+1;
		emp.setId(newEmpId);
		JSONObject jsonObj=emp.getJson();
		employeeList.put(jsonObj);
		JSONObject root= new JSONObject();
		root.put(Constants.EMPLOYEES,employeeList);
		writeData(root);

	}

	/* (non-Javadoc)
	 * @see com.ems.service.AbstractFileService#deleteData(int)
	 */
	@Override
	public synchronized JSONObject  deleteData(int empId) throws Exception {
		JSONArray employeeList= readData();
		JSONObject jsonObj=null;
		boolean empFound=false;
		for(int index=0;index<employeeList.length();index++) {
			jsonObj=(JSONObject) employeeList.get(index);
			if (jsonObj.getInt(Constants.EMPLOYEE_ID)==empId) {
				empFound=true;
				employeeList.remove(index);
				break;
			}
		}
		if(!empFound) {
			throw new Exception("Employee with id="+empId+" not found in database.");
		}
		JSONObject root= new JSONObject();
		root.put(Constants.EMPLOYEES,employeeList);
		writeData(root);

		return jsonObj;

	}

	/* (non-Javadoc)
	 * @see com.ems.service.AbstractFileService#updateData(com.ems.object.Employee)
	 */
	@Override
	public synchronized void updateData(Employee emp) throws Exception {
		JSONArray employeeList= readData();
		JSONObject jsonObj;
		boolean empFound=false;
		for(int index=0;index<employeeList.length();index++) {
			jsonObj=(JSONObject) employeeList.get(index);
			if (jsonObj.getInt(Constants.EMPLOYEE_ID)==emp.getId()) {
				empFound=true;
				jsonObj.put(Constants.EMPLOYEE_NAME, emp.getFullName());
				jsonObj.put(Constants.EMPLOYEE_AGE, emp.getAge());
				jsonObj.put(Constants.EMPLOYEE_SALARY, emp.getSalary());
				break;
			}
		}
		if(!empFound) {
			throw new Exception("Employee with id="+emp.getId()+" not found in database.");
		}
		JSONObject root= new JSONObject();
		root.put(Constants.EMPLOYEES,employeeList);
		writeData(root);

	}
	
	/**
	 * Write data.
	 *
	 * @param empJsonObj the emp json obj
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private synchronized void writeData(JSONObject empJsonObj) throws IOException {
		try (FileWriter file = new FileWriter(this.getJsonFileAbsolutePath(),false)) {
			file.write(empJsonObj.toString());

		}
	}
	
	/**
	 * Read data.
	 *
	 * @return the JSON array
	 * @throws Exception the exception
	 */
	private JSONArray readData() throws Exception {
		if (this.getStatus()==FileStatus.FAILED || this.getStatus()==FileStatus.NONE) {
			throw new Exception("Database File doesn't exists");
		}
		JSONArray empJsonArray= new JSONArray();
		String jsonData=UtilityFunctions.readJsonFile(this.getJsonFileAbsolutePath());
		JSONObject employeeJsonObj =  new JSONObject(jsonData);
		if(employeeJsonObj.has(Constants.EMPLOYEES)) {
			return employeeJsonObj.getJSONArray(Constants.EMPLOYEES);
		}else {
			return empJsonArray;
		}

	}

	/**
	 * Gets the max id.
	 *
	 * @param employeeList the employee list
	 * @return the max id
	 * @throws JSONException the JSON exception
	 */
	private synchronized int getMaxId(JSONArray employeeList) throws JSONException {
		int max=0;
		int empId=0;
		for(int index=0;index<employeeList.length();index++) {
			JSONObject emp=employeeList.getJSONObject(index);
			empId= emp.getInt(Constants.EMPLOYEE_ID);
			if(empId>max) {
				max=empId;
			}
		}
		return max;
	}

}
