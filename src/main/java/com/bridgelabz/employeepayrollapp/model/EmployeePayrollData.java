package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
public @Data class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	
	
	@ElementCollection
	
	private List<String> department;

	public EmployeePayrollData() {

	}
	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.updateEmployeePayrollData(employeePayrollDTO);
	}

	
	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender = employeePayrollDTO.gender;
		this.startDate = employeePayrollDTO.startDate;
		this.note = employeePayrollDTO.note;
		this.profilePic = employeePayrollDTO.profilePic;
		this.department = employeePayrollDTO.department;		
	}

}
