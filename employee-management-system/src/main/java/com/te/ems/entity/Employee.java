package com.te.ems.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
  @Id
  private String employeeId;
  private String employeeDOJ;
  private String employeeName;
  
  @OneToOne(cascade = CascadeType.ALL)
  private User userCredential;//has a relationship with USer class
}
