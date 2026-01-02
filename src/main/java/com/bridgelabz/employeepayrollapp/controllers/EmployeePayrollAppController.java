package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollAppController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {

		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respdto = new ResponseDTO("Get call success", empDataList);

		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.getEmployeePayrollDataById(empId); 
		ResponseDTO respdto = new ResponseDTO("Get call success for id:" + empId, empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.createEmployeePayrollData(empPayrollDTO); 
		ResponseDTO respdto = new ResponseDTO("created employeepayroll data successfully: " + empPayrollDTO, empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {

		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.updateEmployeePayrollData(empPayrollDTO);
		ResponseDTO respdto = new ResponseDTO("updated employeepayroll data successfully: ", empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respdto = new ResponseDTO("deleted successfully: ", "deleted id:" + empId);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);

	}

}
