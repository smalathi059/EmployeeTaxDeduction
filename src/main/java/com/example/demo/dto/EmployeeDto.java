package com.example.demo.dto;

import java.time.LocalDate;

public class EmployeeDto {
	
	 private String employeeId;

	    private String firstName;

	    private String lastName;
	    
	    private String email;
	    
	    private String phoneNumbers;
	   
	    private LocalDate doj;
	    
	    private double salary;

		public EmployeeDto(String employeeId, String firstName, String lastName, String email, String phoneNumbers,
				LocalDate doj, double salary) {
			super();
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumbers = phoneNumbers;
			this.doj = doj;
			this.salary = salary;
		}
	    
	    
}
