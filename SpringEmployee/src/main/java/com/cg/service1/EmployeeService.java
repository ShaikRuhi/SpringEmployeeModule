package com.cg.service1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;
import com.cg.exception.EmployeeException;
import com.cg.repo1.EmployeeRepo;
@Service
@PersistenceContext
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EntityManager em;
	@Autowired
	private EmployeeRepo repo;
	@Override
	public Employee createEmployee(Employee emp) throws EmployeeException{
		// TODO Auto-generated method stub
		Boolean boolean1=validateEmployee(emp);
		if(boolean1) {
			repo.save(emp);
		}else
		{
			throw new EmployeeException("Validation failed");
		}
		
		
		
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException{
		
		 Employee employee= repo.EmployeeDetails(emp.getEid());
		 Boolean boolean1=validateEmployee(emp);
			if(boolean1) {
		employee.setEname(emp.getEname());
		employee.setProject(emp.getProject());
		employee.setSalary(emp.getSalary());
		repo.save(employee);
			}else {
				throw new EmployeeException("Validation failed");
			}
		
		return employee;
		
		
	}

	@Override
	public boolean deleteEmployee(String eid) throws EmployeeException{
	Employee e=repo.EmployeeDetails(eid);
		if(e!=null) {
			repo.deleteById(eid);
		return true;
		}
		else {
		return false;
	}
	}
	@Override
	public List<Employee> getEmployeeDetails(Employee emp)throws EmployeeException {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(String eid)throws EmployeeException {
		// TODO Auto-generated method stub
		return repo.EmployeeDetails(eid);
	}
	@Override
	public boolean validateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		if(validateName(emp.getEname())){
		return true;
	}
		return false;
	}
	
	
	private boolean validateName(String name) throws EmployeeException{
		if(name.isEmpty() ||name==null){
			throw new EmployeeException("Employee name cannot be empty");
		}
		else {
			if(!name.matches("[A-Z][A-za-z]{2,}")){
				throw new EmployeeException("Employee name should start with capital letter and should contain only alphabets and size should be greater than two");
			}
		}
		return true;
	}

}
