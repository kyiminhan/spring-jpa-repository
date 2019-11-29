package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.web.dto.DeptDto;

/**
 * The Interface DepartmentService.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service <BR>
 *        DepartmentService.java <BR>
 */
public interface DepartmentService extends BaseService<DeptDto> {

	/**
	 * Save.
	 *
	 * @param deptDto the dept dto
	 */
	void save(DeptDto deptDto);

	/**
	 * Update.
	 *
	 * @param deptDto the dept dto
	 */
	void update(DeptDto deptDto);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(int id);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the dept dto
	 */
	DeptDto findById(Integer id);

	/**
	 * Find all.
	 *
	 * @return the collection
	 */
	Collection<DeptDto> findAll();
}