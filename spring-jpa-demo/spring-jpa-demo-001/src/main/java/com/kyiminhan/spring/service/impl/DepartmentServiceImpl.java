package com.kyiminhan.spring.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.spring.dao.DepartmentDao;
import com.kyiminhan.spring.entity.Department;
import com.kyiminhan.spring.service.DepartmentService;

import lombok.Setter;

/**
 * The Class DepartmentServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.service.impl </BR>
 *        DepartmentServiceImpl.java </BR>
 */
@Service
@Transactional

/**
 * Sets the department dao.
 *
 * @param departmentDao the new department dao
 */
@Setter(onMethod = @__(@Autowired))
public class DepartmentServiceImpl implements DepartmentService {

	/** The department dao. */
	private DepartmentDao departmentDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#save(com.kyiminhan.spring.
	 * entity .Department)
	 */
	@Override
	public void save(final Department department) {
		this.departmentDao.save(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#update(com.kyiminhan.spring.
	 * entity.Department)
	 */
	@Override
	public void update(final Department department) {
		this.departmentDao.update(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#delete(com.kyiminhan.spring.
	 * entity.Department)
	 */
	@Override
	public void delete(final Department department) {
		this.departmentDao.delete(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.DepartmentService#findById(java.lang.Integer)
	 */
	@Override
	public Department findById(final Integer id) {
		return this.departmentDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.service.DepartmentService#getAll()
	 */
	@Override
	public Collection<Department> findAll() {
		return this.departmentDao.findAll();
	}
}