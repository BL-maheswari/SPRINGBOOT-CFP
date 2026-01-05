package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		List<EmployeePayrollData> empDataList = new ArrayList<>();

		empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("pankaj", 30000)));
		return empDataList;

	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//		EmployeePayrollData empdata = null;
//		empdata = new EmployeePayrollData(1, new EmployeePayrollDTO("pankaj", 30000));
//		return empdata;
		
		
		return employeePayrollList.stream()
				.filter(empData->empData.getEmployeeId()==empId)
				.findFirst()
				.orElseThrow(()->new EmployeePayrollException("employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(1, employeePayrollDTO);
		return empdata;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, employeePayrollDTO);
		return empData;

	}

	@Override
	public void deleteEmployeePayrollData(int empId) {

	}

}
