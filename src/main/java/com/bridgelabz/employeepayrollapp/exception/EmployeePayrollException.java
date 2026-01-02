package com.bridgelabz.employeepayrollapp.exception;

public class EmployeePayrollException extends RuntimeException {

	private String message;

	public EmployeePayrollException(String message) {
		super(message);
	}

}
