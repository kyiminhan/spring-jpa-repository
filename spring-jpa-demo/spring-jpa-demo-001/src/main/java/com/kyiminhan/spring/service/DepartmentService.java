package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.spring.entity.Department;

/**
 * The Interface DepartmentService.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 16, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.service </BR>
 *        DepartmentService.java </BR>
 */
public interface DepartmentService {

	/**
	 * Save.
	 *
	 * @param Department the department
	 */
	void save(Department department);

	/**
	 * Update.
	 *
	 * @param Department the department
	 */
	void update(Department department);

	/**
	 * Delete.
	 *
	 * @param Department the department
	 */
	void delete(Department department);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return Department
	 */
	Department findById(Integer id);

	/**
	 * Find all.
	 *
	 * @return Collection
	 */
	Collection<Department> findAll();
}