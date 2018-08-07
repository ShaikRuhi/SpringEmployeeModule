package com.cg.repo1;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	
	/*@Query("UPDATE Employee e SET e.project=:project where e.eid=:id")
	String updateEmployee(@Param("id")String eid);*/
	
	@Query("SELECT e from Employee e where e.eid=:id")
	Employee EmployeeDetails(@Param("id")String eid);
	/*@Query("SELECT e from Employee e")
	List<Employee> getEmployeeDetails(Employee emp);*/
	
	
	
}
