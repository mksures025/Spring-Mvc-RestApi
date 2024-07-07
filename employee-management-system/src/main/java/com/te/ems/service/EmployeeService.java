package com.te.ems.service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegistrationDTO;

import antlr.collections.List;

public interface EmployeeService {
//	EmployeeDTO getEmployeeDTO(String employeeId);

	public String registerData(RegistrationDTO registerationDTO);

	String updatedRegistrationData(String employeeId, String employeeName);

	 public boolean deleteData(String employeeId);

	public boolean deleteEmployee(String employeeId);

	public List fetechDetails();

	
}
