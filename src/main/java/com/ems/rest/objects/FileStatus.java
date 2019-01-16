package com.ems.rest.objects;


/**
 * The Enum FileStatus. It contains statuses for json file creation on application startup.
 */
public enum FileStatus {
	
	/** The created. Status if file is created successfully or already exist.*/
	CREATED,
	
	/** The failed. Status if file creation fails. */
	FAILED,
	
	/** The none. Default Status.*/
	NONE
}
