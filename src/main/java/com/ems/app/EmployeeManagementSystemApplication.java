
package com.ems.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ems.common.Constants;
import com.ems.service.FileService;


/**
 * The Class EmployeeManagementSystemApplication. For launching Spring Application
 * and using context for running and initializing application.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.ems"})
public class EmployeeManagementSystemApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = 
				SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		String filePath = ctx.getEnvironment().getProperty(Constants.FILE_PATH);
		String fileName = ctx.getEnvironment().getProperty(Constants.FILE_NAME);
		FileService.getSingleTonObject().createFile(filePath,fileName);

	}

}

