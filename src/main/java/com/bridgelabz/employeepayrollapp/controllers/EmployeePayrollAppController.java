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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j

public class EmployeePayrollAppController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {

		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respdto = new ResponseDTO("Get call success", empDataList);

		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.getEmployeePayrollDataById(empId); 
		ResponseDTO respdto = new ResponseDTO("Get call success for id:" + empId, empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department){
		List<EmployeePayrollData> empDataList=null;
		empDataList=employeePayrollService.getEmployeesByDepartment(department);
		ResponseDTO respDTO=new ResponseDTO("get call for id succuessfull",empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK)
	}

	@PostMapping(value = {"","/"})
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.createEmployeePayrollData(empPayrollDTO); 
		ResponseDTO respdto = new ResponseDTO("created employeepayroll data successfully: " + empPayrollDTO, empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {

		EmployeePayrollData empdata = null;
		empdata =employeePayrollService.updateEmployeePayrollData(0, empPayrollDTO);
		ResponseDTO respdto = new ResponseDTO("updated employeepayroll data successfully: ", empdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);

	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respdto = new ResponseDTO("deleted successfully: ", "deleted id:" + empId);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);

	}

}
