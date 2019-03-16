package com.kyiminhan.spring.dao;

import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.entity.Employee;

/**
 * The Interface EmployeeDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.dao </BR>
 *        EmployeeDao.java </BR>
 */
@Repository
public interface EmployeeDao extends BaseDao<Employee> {
}