package com.ems.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ems.object.Employee;
import com.ems.rest.objects.FileStatus;


/**
 * The Class AbstractFileService. Abstract class for managing read/write/update/delete operations on json 
 * file database.
 */
public abstract class AbstractFileService {
	
	/** The absolute file path. */
	private String absoluteFilePath="";
	
	/** The json file. */
	private File jsonFile=null; 
	
	/** The file creation error message. */
	private String fileCreationErrorMessage="";
	
	/** The status. */
	private FileStatus status=FileStatus.NONE;
	
	/**
	 * Read all data.
	 *
	 * @return the JSON array
	 * @throws Exception the exception
	 */
	public abstract JSONArray readAllData() throws  Exception;
	
	/**
	 * Adds the data.
	 *
	 * @param emp the emp
	 * @throws Exception the exception
	 */
	public abstract void addData(Employee emp) throws  Exception;
	
	/**
	 * Delete data.
	 *
	 * @param empId the emp id
	 * @return the JSON object
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public abstract JSONObject deleteData(int empId) throws FileNotFoundException, JSONException, IOException, Exception;
	
	/**
	 * Update data.
	 *
	 * @param emp the emp
	 * @throws FileNotFoundException the file not found exception
	 * @throws JSONException the JSON exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public abstract void updateData(Employee emp) throws FileNotFoundException, JSONException, IOException, Exception;
	
	/**
	 * Creates the file.
	 *
	 * @param filePath the file path
	 * @param fileName the file name
	 */
	public void createFile(String filePath,String fileName) {
		try {
			absoluteFilePath=filePath+fileName;
			if (jsonFile==null || (jsonFile!=null && !jsonFile.exists())) {
				jsonFile= new File(absoluteFilePath);
				jsonFile.createNewFile();

			}
			this.status=FileStatus.CREATED;
		}catch(Exception ex) {
			ex.printStackTrace();
			this.fileCreationErrorMessage=ex.getMessage();
			this.status=FileStatus.FAILED;
		}

	}

	/**
	 * Gets the json file absolute path.
	 *
	 * @return the json file absolute path
	 */
	public String getJsonFileAbsolutePath() {
		return absoluteFilePath;
	}

	/**
	 * Gets the json file.
	 *
	 * @return the json file
	 */
	public File getJsonFile() {
		return jsonFile;
	}
	
	/**
	 * Gets the file creation error message.
	 *
	 * @return the file creation error message
	 */
	public String getFileCreationErrorMessage() {
		return fileCreationErrorMessage;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public FileStatus getStatus() {
		return status;
	}

}
