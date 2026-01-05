package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;



@Data
public @ToString class EmployeePayrollDTO {
	
	//@NotEmpty(message = "employee name not be null")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
	public String name;

	@Min(value = 500, message = "mmin wage should be more than 500")
	public long salary;
	
	@Pattern(regexp ="male|female",message="gender needs to be male or female")
	public String gender;
	
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message="startdate should not be empty")
	@PastOrPresent(message="start date should be past or todays date")
	public LocalDate startDate;

	
	@NotBlank(message="note cannnot be empty")
	public String note;
	
	@NotBlank(message="profilepic cannot be empty")
	public String profilePic;
	
	@NotNull(message="department should not be empty")
	public List<String> department;
	
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

	
}
