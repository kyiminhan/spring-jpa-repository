package com.kyiminhan.spring.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.common.types.Status;
import com.kyiminhan.spring.dao.DepartmentDao;
import com.kyiminhan.spring.entity.Department;
import com.kyiminhan.spring.service.DepartmentService;
import com.kyiminhan.web.dto.DeptDto;

import lombok.Setter;

/**
 * The Class DepartmentServiceImpl.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service.impl <BR>
 *        DepartmentServiceImpl.java <BR>
 */
@Service
@Transactional
@Setter(onMethod = @__(@Autowired))
public class DepartmentServiceImpl extends BaseServiceImpl<DeptDto> implements DepartmentService {

	private static final long serialVersionUID = 1L;

	/** The department dao. */
	private DepartmentDao deptDap;

	/**
	 * Save.
	 *
	 * @param deptDto the dept dto
	 */
	@Override
	public void save(final DeptDto deptDto) {
		Department department = convertEntity(deptDto);
		department.setStatus(Status.ACTIVE);
		this.deptDap.save(department);
	}

	/**
	 * Update.
	 *
	 * @param deptDto the dept dto
	 */
	@Override
	public void update(final DeptDto deptDto) {
		Department department = convertEntity(deptDto);
		department.setStatus(Status.ACTIVE);
		this.deptDap.update(department);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(final int id) {
		Department department = this.deptDap.findById(id);
		department.setStatus(Status.INACTIVE);
		this.deptDap.update(department);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the dept dto
	 */
	@Override
	public DeptDto findById(final Integer id) {
		return convertDTO(this.deptDap.findById(id));
	}

	/**
	 * Find all.
	 *
	 * @return the collection
	 */
	@Override
	public Collection<DeptDto> findAll() {
		Collection<DeptDto> deptDtos = new ArrayList<DeptDto>();
		this.deptDap.findAll().forEach(d -> deptDtos.add(convertDTO(d)));
		return deptDtos;
	}
}