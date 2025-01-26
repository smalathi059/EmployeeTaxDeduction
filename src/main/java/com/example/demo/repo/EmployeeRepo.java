package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{
	 EmployeeEntity findByEmployeeId(String employeeId);
	 
	 @Query(value = "select * from employee_details where last_name =?1",nativeQuery = true)
	 List<EmployeeEntity> findByEmployeelastName(String lastName);
	 
}
