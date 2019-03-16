package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.spring.entity.Employee;

/**
 * The Interface EmployeeService.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 16, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.service </BR>
 *        EmployeeService.java </BR>
 */
public interface EmployeeService {

	/**
	 * Save.
	 *
	 * @param employee the employee
	 */
	void save(Employee employee);

	/**
	 * Update.
	 *
	 * @param employee the employee
	 */
	void update(Employee employee);

	/**
	 * Delete.
	 *
	 * @param employee the employee
	 */
	void delete(Employee employee);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return Employee
	 */
	Employee findById(Integer id);

	/**
	 * Find all.
	 *
	 * @return Collection
	 */
	Collection<Employee> findAll();
}