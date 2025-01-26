package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaxDetails;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("EmployeeDetails")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employeeId/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeById(employeeId);
        return employee.orElse(null); 
    }


    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/tax/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public TaxDetails getTaxDetails(@PathVariable String employeeId) {
        TaxDetails taxDetails = employeeService.getTaxDetails(employeeId);
        if (taxDetails == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tax details not found");
        }
        return taxDetails;
    }
    
    @GetMapping("/getByLastname/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeEntity>> getEmployeesbylastname(@PathVariable String lastName) {
        List<EmployeeEntity> employees = employeeService.getEmployeesByLastname(lastName);        
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/getByfirstname/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmployeeEntity>> getEmployeesbyfirstname(@PathVariable String firstName) {
        List<EmployeeEntity> employees = employeeService.getEmployeesByfirstname(firstName);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}


