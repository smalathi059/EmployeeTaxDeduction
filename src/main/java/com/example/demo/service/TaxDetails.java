package com.example.demo.service;

public class TaxDetails {
	
	private double yearlySalary;
    private double tax;
    private double cess;
    
    
	public TaxDetails(double yearlySalary, double tax, double cess) {
		super();
		this.yearlySalary = yearlySalary;
		this.tax = tax;
		this.cess = cess;
	}
	public double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getCess() {
		return cess;
	}
	public void setCess(double cess) {
		this.cess = cess;
	}
}
