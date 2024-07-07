package com.te.ems.repository;

import java.util.Optional;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegistrationDTO;
import com.te.ems.entity.Employee;

import antlr.collections.List;

public interface EmployeeRepository {

	public String insertData(Employee employee);

//	Optional<Employee> getEmployee(String employeeId);

	String updateName(String employeeId, String employeeName);

//	boolean deleteEmployeeId(String employeeId);

	boolean deleteEmployee(String employeeId);

	public List fetechDetails();

}
