package com.kyiminhan.web.dto;

import java.io.Serializable;

import com.kyiminhan.common.types.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class EmpDto.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.web.dto <BR>
 * EmpDto.java <BR>
 */
@Getter
@Setter

/**
 * Instantiates a new emp dto.
 */

/**
 * Instantiates a new emp dto.
 */

/**
 * Instantiates a new emp dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new emp dto.
 *
 * @param id      the id
 * @param name    the name
 * @param email   the email
 * @param address the address
 * @param phone   the phone
 * @param status  the status
 */

/**
 * Instantiates a new emp dto.
 *
 * @param id the id
 * @param name the name
 * @param email the email
 * @param address the address
 * @param phone the phone
 * @param status the status
 */

/**
 * Instantiates a new emp dto.
 *
 * @param id the id
 * @param name the name
 * @param email the email
 * @param address the address
 * @param phone the phone
 * @param status the status
 */
@AllArgsConstructor

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

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class EmpDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The name. */
	private String name;

	/** The email. */
	private String email;

	/** The address. */
	private String address;

	/** The phone. */
	private String phone;

	/** The status. */
	private Status status;
}
