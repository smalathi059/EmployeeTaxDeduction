package com.example.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeerepo;

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeerepo.save(employee);
    }

    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return employeerepo.findById(id);
    }
    
    public List<EmployeeEntity> getAllEmployees() {
        return employeerepo.findAll();
    }

    public double calculateYearlySalary(EmployeeEntity employee, LocalDate endDate) {
        LocalDate startDate = employee.getDoj();
        long monthsWorked = ChronoUnit.MONTHS.between(startDate.withDayOfMonth(1), endDate.withDayOfMonth(1));
        return employee.getSalary() * monthsWorked;
    }

    public double calculateTax(double yearlySalary) {
        double tax = 0;
        if (yearlySalary > 250000) {
            if (yearlySalary <= 500000) {
                tax = (yearlySalary - 250000) * 0.05;
            } else if (yearlySalary <= 1000000) {
                tax = 250000 * 0.05 + (yearlySalary - 500000) * 0.1;
            } else {
                tax = 250000 * 0.05 + 500000 * 0.1 + (yearlySalary - 1000000) * 0.2;
            }
        }
        return tax;
    }

    public double calculateCess(double yearlySalary) {
        double cess = 0;
        if (yearlySalary > 2500000) {
            cess = (yearlySalary - 2500000) * 0.02;
        }
        return cess;
    }

    public TaxDetails getTaxDetails(String employeeId) {
        EmployeeEntity employee = employeerepo.findByEmployeeId(employeeId);
        if (employee == null) {
            return null;
        }
        LocalDate endDate = LocalDate.now();
        double yearlySalary = calculateYearlySalary(employee, endDate);
        double tax = calculateTax(yearlySalary);
        double cess = calculateCess(yearlySalary);
        return new TaxDetails(yearlySalary, tax, cess);
    }
    
    public List<EmployeeEntity> getEmployeesByLastname(String lastname) {
        return employeerepo.findByEmployeelastName(lastname);
    }
}
