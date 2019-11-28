package com.kyiminhan.spring.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface BaseDao.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @param <KYIMINHAN> the generic type
 * @since Nov 28, 2019 <BR>
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.spring.dao <BR>
 * BaseDao.java <BR>
 */
@NoRepositoryBean
public interface BaseDao<KYIMINHAN extends Serializable> extends JpaRepository<KYIMINHAN, Integer> {

}