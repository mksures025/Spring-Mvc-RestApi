package com.te.ems.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.mysql.cj.Query;
import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Employee;
import com.te.ems.response.SuccessResponse;

import antlr.collections.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mysql");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public String insertData(Employee employee) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

//	@Override
//	public Optional<Employee> getEmployee(String employeeId) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

	@Override
	public String updateName(String employeeId, String employeeName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee.getEmployeeId().equals(employeeId)) {

			employee.setEmployeeName(employeeName);
			entityManager.persist(employee);
			entityTransaction.commit();
			return employee.getEmployeeName();
		}

		return null;
	}

	@Override
	public boolean deleteEmployee(String employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List fetechDetails() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		javax.persistence.Query query = entityManager.createQuery("FROM employee");
		java.util.List resultList = query.getResultList();
		entityTransaction.commit();
		return (List) resultList;
	}

//	@Override
//	public List fetechDetails() {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		System.out.println("hii");
//		javax.persistence.Query createQuery = entityManager.createQuery("FROM Employee");
//		List list = (List) createQuery.getResultList();
//		entityTransaction.commit();
//		return (List) createQuery;
//
//	}

}
