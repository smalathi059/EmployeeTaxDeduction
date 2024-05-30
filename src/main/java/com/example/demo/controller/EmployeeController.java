package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaxDetails;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("EmployeeDetails")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee) {
        EmployeeEntity savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employeeId/{employeeId}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        Optional<EmployeeEntity> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(value -> ResponseEntity.ok().body(value))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/tax/{employeeId}")
    public ResponseEntity<TaxDetails> getTaxDetails(@PathVariable String employeeId) {
        TaxDetails taxDetails = employeeService.getTaxDetails(employeeId);
        if (taxDetails != null) {
            return new ResponseEntity<>(taxDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


