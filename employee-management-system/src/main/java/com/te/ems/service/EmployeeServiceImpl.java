package com.te.ems.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegistrationDTO;
import com.te.ems.entity.Employee;
import com.te.ems.entity.User;
import com.te.ems.repository.EmployeeRepository;

import antlr.collections.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

//	@Override
//	public EmployeeDTO getEmployeeDTO(String employeeId) {
//		Optional<Employee> employeeOP = employeeRepository.getEmployee(employeeId);
//
//		if (employeeOP.isPresent()) {
//			Employee employee = employeeOP.get();
//			return EmployeeDTO.builder().employeeId(employeeId).employeeDOJ(employee.getEmployeeDOJ())
//					.employeeName(employee.getEmployeeName()).userName(employee.getUserCredential().getUserName())
//					.build();
//		}
//		return null;
//	}

	@Override
	public String registerData(RegistrationDTO registerationDTO) {
		Employee employee = Employee.builder().employeeId(registerationDTO.getEmployeeId())
				.employeeName(registerationDTO.getEmployeeName()).employeeDOJ(registerationDTO.getEmployeeDOJ())
				.build();

		User user = User.builder().UserName(registerationDTO.getUserName())
				.UserPasssword(registerationDTO.getPassword()).employee(employee).build();

		employee.setUserCredential(user);

		String employeeId = employeeRepository.insertData(employee);

		return employeeId;
	}

	@Override
	public String updatedRegistrationData(String employeeId, String employeeName) {

		String name = employeeRepository.updateName(employeeId, employeeName);

		return name;
	}

	@Override
	public boolean deleteData(String employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		 return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public List fetechDetails() {
		return employeeRepository.fetechDetails();
	}

	
	
	

	
	}

	

	
	

