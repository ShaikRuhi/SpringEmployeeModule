package com.cg.service1;

import java.util.List;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;

public interface IEmployeeService {

	Employee createEmployee(Employee emp)throws EmployeeException;
	Employee updateEmployee(Employee emp)throws EmployeeException;
	boolean deleteEmployee(String eid)throws EmployeeException;
	List<Employee> getEmployeeDetails(Employee emp)throws EmployeeException;
	Employee getEmployeeById(String eid)throws EmployeeException;
	boolean validateEmployee(Employee emp) throws EmployeeException;
	
}
