package com.kyiminhan.spring.service;

import java.io.Serializable;

/**
 * The Class BaseService.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.service <BR>
 *        BaseService.java <BR>
 */
public interface BaseService<DTO extends Serializable> extends Converter, Serializable {

}