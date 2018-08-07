package com.cg.controller1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;
import com.cg.service1.IEmployeeService;

@RestController
@Transactional

public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) throws EmployeeException {
		try {
			service.createEmployee(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return emp;
		
	}
	@RequestMapping(value="/updateEmployee",method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) throws EmployeeException {
		Employee emp1 = null;
		try {
			emp1 = service.updateEmployee(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return emp1;
		
	}
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.DELETE)
	public boolean deleteEmployee(String eid) throws EmployeeException {
	boolean b = false;
	try {
		b = service.deleteEmployee(eid);
	} catch (EmployeeException e) {
		throw e;
	}
		return b;
		
	}
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET)
	public Employee getEmployeeById(String eid) throws EmployeeException {
		Employee emp = null;
		try {
			emp = service.getEmployeeById(eid);
		} catch (EmployeeException e) {
			throw e;
		}
		return emp;
		
	}
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public List<Employee> getEmployeeDetails(Employee emp) throws EmployeeException {
		List<Employee> e1 = null;
		try {
			
			 e1=service.getEmployeeDetails(emp);
		} catch (EmployeeException e) {
			throw e;
		}
		return e1;
		
	}
	
}
