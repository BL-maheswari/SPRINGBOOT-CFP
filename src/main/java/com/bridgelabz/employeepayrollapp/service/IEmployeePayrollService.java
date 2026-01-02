package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public interface IEmployeePayrollService {
	
	List<EmployeePayrollData> getEmployeePayrollData();
	
	
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
	
	void deleteEmployeePayrollData(int empId);
	
	

}
