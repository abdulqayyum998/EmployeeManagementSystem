package com.ems.app.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ems.common.Constants;
import com.ems.object.Employee;
import com.ems.rest.objects.FilterOptions;
import com.ems.rest.objects.ResponseStatus;
import com.ems.service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeManagementSystemApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EmployeeManagementSystemApplicationTests {
	   
   	/** The mvc. */
   	private MockMvc mvc;

	   
	   /** The web application context. */
   	@Autowired
	   WebApplicationContext webApplicationContext;
	   
   	/**
   	 * Sets the up.
   	 */
   	@Before
	   public void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String filePath = webApplicationContext.getEnvironment().getProperty(Constants.FILE_PATH);
			String fileName = webApplicationContext.getEnvironment().getProperty(Constants.FILE_NAME);
			FileService.getSingleTonObject().createFile(filePath,fileName);
	   }
	
	/**
	 * Gets the all test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void GetAll_TestCase() throws Exception {
		String uri = "/employee/all";
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}
	
	/**
	 * Gets the employee by id test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void GetEmployeeById_TestCase() throws Exception {
		String uri = "/employee/1";
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}
	
	/**
	 * Adds the employee test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void AddEmployee_TestCase() throws Exception {
		String uri = "/employee/add";
		Employee emp= new Employee(0,"abdul",30.6,20000.0);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(emp);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}
	
	/**
	 * Update employee test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void updateEmployee_TestCase() throws Exception {
		String uri = "/employee/update";
		Employee emp= new Employee(1,"abdul",30.6,20000.0);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(emp);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}
	
	/**
	 * Delete employee test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void deleteEmployee_TestCase() throws Exception {
		String uri = "/employee/delete/1";
	
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}
	
	/**
	 * Filter by age test case.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void filterByAge_TestCase() throws Exception {
		String uri = "/employee/filterbyage";
		FilterOptions filterOptions= new FilterOptions("lt", 70, "asc");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(filterOptions);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   JSONObject jsonObject= new JSONObject(content);
		 // Todo: verifying other results to be done
		   assertTrue(jsonObject.get("responseStatus").toString().equalsIgnoreCase(ResponseStatus.SUCCESS.toString()));
	}

}

