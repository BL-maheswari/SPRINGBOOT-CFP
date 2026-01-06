package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {
	
	
	
	
	private static final String message="Exception while processing the REST request";

	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO>handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
	log.error("Invalid Date format",httpMessageNotReadableException);
	ResponseDTO responseDTO = new ResponseDTO(message, "should have date in the format dd MM yyyy");
	return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
}
	

	
	
	
	
	
	
	
	
	
	
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(

			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("exception while processing RESt request", errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
		ResponseDTO responseDTO = new ResponseDTO("exception while passing the REST request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}