package com.kyiminhan.spring.service;

import org.springframework.beans.BeanUtils;

import com.kyiminhan.spring.entity.Department;
import com.kyiminhan.spring.entity.Employee;
import com.kyiminhan.web.dto.DeptDto;
import com.kyiminhan.web.dto.EmpDto;

import lombok.NonNull;

/**
 * The Class Converter.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service <BR>
 *        Converter.java <BR>
 */
public interface Converter {

	/**
	 * Convert entity.
	 *
	 * @param deptDto the dept dto
	 * @return the department
	 */
	default Department convertEntity(@NonNull DeptDto deptDto) {
		Department department = Department.builder().build();
		BeanUtils.copyProperties(deptDto, department, Department.class);
		return department;
	}

	/**
	 * Convert entity.
	 *
	 * @param empDto the emp dto
	 * @return the employee
	 */
	default Employee convertEntity(@NonNull EmpDto empDto) {
		Employee employee = Employee.builder().build();
		BeanUtils.copyProperties(empDto, employee, Employee.class);
		return employee;
	}

	/**
	 * Convert DTO.
	 *
	 * @param department the department
	 * @return the dept dto
	 */
	default DeptDto convertDTO(@NonNull Department department) {
		DeptDto deptDto = DeptDto.builder().build();
		BeanUtils.copyProperties(department, deptDto, DeptDto.class);
		return deptDto;
	}

	/**
	 * Convert DTO.
	 *
	 * @param employee the employee
	 * @return the emp dto
	 */
	default EmpDto convertDTO(@NonNull Employee employee) {
		EmpDto empDto = EmpDto.builder().build();
		BeanUtils.copyProperties(employee, empDto, EmpDto.class);
		return empDto;
	}

}