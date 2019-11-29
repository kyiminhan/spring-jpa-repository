package com.kyiminhan.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Where;

import com.kyiminhan.common.types.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Employee.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.entity <BR>
 *        Employee.java <BR>
 */
@Getter
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Hash code.
 *
 * @return the int
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
 * @param status  the status
 */
@AllArgsConstructor
@Entity
@Where(clause = "status='ACTIVE'")
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

	/** The status. */
	@Enumerated(EnumType.STRING)
	@Column
	private Status status;

	/** The created date. */
	@Column(updatable = false)
	private LocalDateTime createdDate;

	/** The created by. */
	@Column(updatable = false)
	private String createdBy;

	/** The last modified date. */
	@Column
	private LocalDateTime lastModifiedDate;

	/** The last modified by. */
	@Column
	private String lastModifiedBy;

	@PrePersist
	public void prePersist() {
		this.createdDate = LocalDateTime.now();
		this.createdBy = "login User";
		this.lastModifiedDate = LocalDateTime.now();
		this.lastModifiedBy = "login User";
	}

	@PreUpdate
	public void preUpdate() {
		this.lastModifiedDate = LocalDateTime.now();
		this.lastModifiedBy = "login User";
	}
}