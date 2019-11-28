package com.kyiminhan.common.converter;

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
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.common.converter <BR>
 * Converter.java <BR>
 */
public class Converter {

	/** The instance. */
	private volatile static Converter instance;

	/**
	 * Instantiates a new converter.
	 */
	private Converter() {
	}

	public static Converter getInstance() {
		if (null == instance) {
			synchronized (Converter.class) {
				if (null == instance) {
					instance = new Converter();
				}
			}
		}
		return instance;
	}

	/**
	 * Convert entity.
	 *
	 * @param deptDto the dept dto
	 * @return the department
	 */
	public Department convertEntity(@NonNull DeptDto deptDto) {
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
	public Employee convertEntity(@NonNull EmpDto empDto) {
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
	public DeptDto convertDTO(@NonNull Department department) {
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
	public EmpDto convertDTO(@NonNull Employee employee) {
		EmpDto empDto = EmpDto.builder().build();
		BeanUtils.copyProperties(employee, empDto, EmpDto.class);
		return empDto;
	}

}