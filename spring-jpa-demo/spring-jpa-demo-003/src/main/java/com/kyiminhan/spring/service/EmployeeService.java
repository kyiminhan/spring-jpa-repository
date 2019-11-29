package com.kyiminhan.spring.service;

import java.util.Collection;

import com.kyiminhan.web.dto.EmpDto;

/**
 * The Interface EmployeeService.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service <BR>
 *        EmployeeService.java <BR>
 */
public interface EmployeeService extends BaseService<EmpDto> {

	/**
	 * Save.
	 *
	 * @param empDto the emp dto
	 */
	void save(EmpDto empDto);

	/**
	 * Update.
	 *
	 * @param empDto the emp dto
	 */
	void update(EmpDto empDto);

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
	 * @return the emp dto
	 */
	EmpDto findById(Integer id);

	/**
	 * Find all.
	 *
	 * @return the collection
	 */
	Collection<EmpDto> findAll();
}