package com.kyiminhan.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.common.converter.Converter;
import com.kyiminhan.common.types.Status;
import com.kyiminhan.spring.dao.EmployeeDao;
import com.kyiminhan.spring.entity.Employee;
import com.kyiminhan.spring.service.EmployeeService;
import com.kyiminhan.web.dto.EmpDto;

import lombok.Setter;

/**
 * The Class EmployeeServiceImpl.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service.impl <BR>
 *        EmployeeServiceImpl.java <BR>
 */
@Service
@Transactional
@Setter(onMethod = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/**
	 * Save.
	 *
	 * @param empDto the emp dto
	 */
	@Override
	public void save(final EmpDto empDto) {
		Employee employee = Converter.getInstance().convertEntity(empDto);
		employee.setStatus(Status.ACTIVE);
		this.employeeDao.save(employee);
	}

	/**
	 * Update.
	 *
	 * @param empDto the emp dto
	 */
	@Override
	public void update(final EmpDto empDto) {
		Employee employee = Converter.getInstance().convertEntity(empDto);
		employee.setStatus(Status.ACTIVE);
		this.employeeDao.saveAndFlush(employee);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(final int id) {
		Employee employee = this.employeeDao.findById(id).orElse(null);
		employee.setStatus(Status.INACTIVE);
		this.employeeDao.saveAndFlush(employee);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the emp dto
	 */
	@Override
	public EmpDto findById(final Integer id) {
		return Converter.getInstance().convertDTO(this.employeeDao.findById(id).orElse(null));
	}

	/**
	 * Find all.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<EmpDto> findAll() {
		Collection<EmpDto> empDtos = new ArrayList<EmpDto>();
		this.employeeDao.findAll().forEach(d -> empDtos.add(Converter.getInstance().convertDTO(d)));
		return empDtos;
	}
}