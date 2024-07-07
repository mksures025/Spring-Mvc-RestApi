package com.te.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RegistrationDTO {
	private String employeeId;
	private String employeeName;
	private String employeeDOJ;
	private String userName;
	private String password;
}
