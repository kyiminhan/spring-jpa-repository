package com.kyiminhan.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Employee.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.entity </BR>
 *        Employee.java </BR>
 */
@Getter
@Setter

/**
 * Builds the.
 *
 * @return Employee
 */
@Builder

/**
 * Can equal.
 *
 * @param other the other
 * @return true, if successful
 */
@EqualsAndHashCode

/**
 * Instantiates a new employee.
 */
@NoArgsConstructor

/**
 * Instantiates a new employee.
 *
 * @param id      the id
 * @param name    the name
 * @param email   the email
 * @param address the address
 * @param phone   the phone
 */
@AllArgsConstructor
@Entity
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	/** The name. */
	@Column
	private String name;

	/** The email. */
	@Column
	private String email;

	/** The address. */
	@Column
	private String address;

	/** The phone. */
	@Column
	private String phone;

}