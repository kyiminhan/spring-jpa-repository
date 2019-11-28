package com.kyiminhan.web.dto;

import java.io.Serializable;

import com.kyiminhan.common.types.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class DeptDto.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.web.dto <BR>
 * DeptDto.java <BR>
 */
@Getter
@Setter

/**
 * Instantiates a new dept dto.
 */

/**
 * Instantiates a new dept dto.
 */

/**
 * Instantiates a new dept dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new dept dto.
 *
 * @param id             the id
 * @param departmentName the department name
 * @param status         the status
 */

/**
 * Instantiates a new dept dto.
 *
 * @param id the id
 * @param departmentName the department name
 * @param status the status
 */

/**
 * Instantiates a new dept dto.
 *
 * @param id the id
 * @param departmentName the department name
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
public class DeptDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The department name. */
	private String departmentName;

	/** The status. */
	private Status status;
}