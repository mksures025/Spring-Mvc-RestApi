package com.te.ems.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.dto.RegistrationDTO;
import com.te.ems.entity.Employee;
import com.te.ems.response.SuccessResponse;
import com.te.ems.service.EmployeeService;

import antlr.collections.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "/app/employee")
@RestController
public class EmployeeController {
	public final EmployeeService employeeService;// constructor injection

//	get dummy 
//	@GetMapping(path = "/dummy", produces = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE })
//	public String dummy() {
//		return "dummy string";
//	}

// step1. This is for body which required for post method,just we create object for RegistrationDTO in dummy method
	@GetMapping(path = "/dummy", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public RegistrationDTO dummy() {

		return new RegistrationDTO();
	}

//TODO
//	step.2 register
	@PostMapping(path = "/register", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> register(@RequestBody RegistrationDTO registerationDTO) {
		String id = employeeService.registerData(registerationDTO);

		return ResponseEntity.ok().body(SuccessResponse.builder().message("A simple message").data(registerationDTO)
				.status(HttpStatus.OK).timestamp(LocalDateTime.now().toString()).build());
	}

//TODO
//	step.3 update 
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> updateRegister(@RequestBody RegistrationDTO registerationDTO) {
		String id1 = employeeService.updatedRegistrationData(registerationDTO.getEmployeeId(),
				registerationDTO.getEmployeeName());

		return ResponseEntity.ok().body(SuccessResponse.builder().message("this is for updation").data(registerationDTO)
				.status(HttpStatus.OK).timestamp(LocalDateTime.now().toString()).build());

	}

//	Step.4 delete
	@DeleteMapping(path = "/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable String employeeId) {
		boolean isdeleteIn = employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok()
				.body(SuccessResponse.builder().message("delete the details sucessfully based on the employeeId")
						.data(employeeId).status(HttpStatus.OK).timestamp(LocalDateTime.now().toString()).build());
	}

//	Step 5 fetch
	@GetMapping(path = "/fetchemployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<SuccessResponse> fetchEmployee() {
		List employees = employeeService.fetechDetails();

		return ResponseEntity.ok()
				.body(SuccessResponse.builder().message("delete the details sucessfully based on the employeeId")
						.data(employees).status(HttpStatus.OK).timestamp(LocalDateTime.now().toString()).build());
	}

}