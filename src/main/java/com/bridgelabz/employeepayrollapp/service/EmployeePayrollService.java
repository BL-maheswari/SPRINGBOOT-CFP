package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	
	
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

//		List<EmployeePayrollData> empDataList = new ArrayList<>();
//
//		empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("pankaj", 30000)));
//		return empDataList;
		 return employeePayrollRepository.findAll();
		

	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//		EmployeePayrollData empdata = null;
//		empdata = new EmployeePayrollData(1, new EmployeePayrollDTO("pankaj", 30000));
//		return empdata;
		
		
//		return employeePayrollList.stream()
//				.filter(empData->empData.getEmployeeId()==empId)
//				.findFirst()
//				.orElseThrow(()->new EmployeePayrollException("employee Not Found"));
		
		return employeePayrollRepository.findById(empId)
				.orElseThrow(()->new EmployeePayrollException("Employeee with employeeId"+empId+"does not exists..!!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empdata = null;
		empdata = new EmployeePayrollData(employeePayrollDTO);
		log.debug("emp data:",empdata);
		employeePayrollList.add(empdata);
		return employeePayrollRepository.save(empdata);

	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(employeePayrollDTO); 
		return employeePayrollRepository.save(empData);

	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		employeePayrollRepository.delete(empData);

	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
		return employeePayrollRepository.findEmployeesByDepartment(department);
	}

}
