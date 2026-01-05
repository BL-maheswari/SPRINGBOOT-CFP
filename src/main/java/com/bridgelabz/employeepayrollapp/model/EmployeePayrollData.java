package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeePayrollData {

	@Id
	private int employeeId;
	private String name;
	private long salary;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		this.employeeId = empId;
		this.name = employeePayrollDTO.getName();
		this.salary = employeePayrollDTO.getSalary();

	}

}
