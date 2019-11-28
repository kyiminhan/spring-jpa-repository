package com.kyiminhan.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import com.kyiminhan.common.types.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Department.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.spring.entity <BR>
 * Department.java <BR>
 */
@Getter
@Setter

/**
 * Builds the.
 *
 * @return Department
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new department.
 */

/**
 * Instantiates a new department.
 */

/**
 * Instantiates a new department.
 */
@NoArgsConstructor

/**
 * Instantiates a new department.
 *
 * @param id             the id
 * @param departmentName the department name
 */

/**
 * Instantiates a new department.
 *
 * @param id the id
 * @param departmentName the department name
 * @param status the status
 */

/**
 * Instantiates a new department.
 *
 * @param id the id
 * @param departmentName the department name
 * @param status the status
 */
@AllArgsConstructor
@Entity
@Where(clause = "status='ACTIVE'")
public class Department implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	/** The department name. */
	@Column
	private String departmentName;

	/** The status. */
	@Enumerated(EnumType.STRING)
	@Column
	private Status status;
}