package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{
	 EmployeeEntity findByEmployeeId(String employeeId);
}
