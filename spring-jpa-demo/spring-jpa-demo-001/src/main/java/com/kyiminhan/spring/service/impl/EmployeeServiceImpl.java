/*
 *
 */
package com.kyiminhan.spring.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyiminhan.spring.dao.EmployeeDao;
import com.kyiminhan.spring.entity.Employee;
import com.kyiminhan.spring.service.EmployeeService;

import lombok.Setter;

/**
 * The Class EmployeeServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.service.impl </BR>
 *        EmployeeServiceImpl.java </BR>
 */
@Service
@Transactional

/**
 * Sets the employee dao.
 *
 * @param employeeDao the new employee dao
 */
@Setter(onMethod = @__(@Autowired))
public class EmployeeServiceImpl implements EmployeeService {

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.EmployeeService#save(com.kyiminhan.spring.entity
	 * .Employee)
	 */
	@Override
	public void save(final Employee employee) {
		this.employeeDao.save(employee);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.EmployeeService#update(com.kyiminhan.spring.
	 * entity.Employee)
	 */
	@Override
	public void update(final Employee employee) {
		this.employeeDao.save(employee);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.service.EmployeeService#delete(com.kyiminhan.spring.
	 * entity.Employee)
	 */
	@Override
	public void delete(final Employee employee) {
		this.employeeDao.delete(employee);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.service.EmployeeService#getAll()
	 */
	@Override
	public Collection<Employee> findAll() {
		return this.employeeDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.service.EmployeeService#findById(java.lang.Integer)
	 */
	@Override
	public Employee findById(final Integer id) {
		return this.employeeDao.findById(id).orElse(null);
	}
}