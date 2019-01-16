Project is based on Spring Boot 2.1.2 and java 8

This work is as per what was written in assignment document. Please go through following points 
before testing it or evaluation. some of the steps not completed because of time limitation on my side.

1- As its test work so no logging has been implemented in it.
2 - As work is small so no separate projects are created for each layer like service layer, domain layer etc.
3 - Basic Exception handling has been done. but its not customized for user friendly messages. In case of error message you will find original error message in Response object. 
4 - Checks on user input hasn't been placed i.e. if user sends in 'at' instead of 'lt' in filters etc

Following are steps for running rest end points.

1- Application port set is 8000 and following would be urls to hit through http client.

Get All Employees - Get Call - http://localhost:8000/employee/all
Get Employee By Id - Get Call - http://localhost:8000/employee/1 ------ where 1 is employee id
Add Employee - Post Call - http://localhost:8000/employee/add ---- Test with like {"id":0,"fullName":"abdul","age":30.3,"salary":1233.00}
Update Employee - Post Call - http://localhost:8000/employee/update ---- Test with like {"id":2,"fullName":"abdul","age":30.3,"salary":1233.00}
Delete Employee - Post Call - http://localhost:8000/employee/delete/1 
Filter and Sort by Age  - Post Call - http://localhost:8000/employee/filterbyage --- Test with like {"operator": "lt", "value": 30, "sort": "asc"}

Work is also with 6 test cases i.e one for each work rest call where for test success both response code and custom response status are checked for test to be successfull. Detail work for verification hasn't been done for verifications like to verify if list returned is sorted or not etc.

