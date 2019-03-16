package com.kyiminhan.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The Class JPAConfig.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.config </BR>
 *        JPAConfig.java </BR>
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.kyiminhan.spring.dao" })
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties", "classpath:db.properties" })
@ComponentScan("com.kyiminhan.spring")
public class JPAConfig implements WebMvcConfigurer {

	/** The mysql driver. */
	@Value("${mysql.driver}")
	private String mysqlDriver;

	/** The jdbc URL. */
	@Value("${mysql.jdbcUrl}")
	private String jdbcURL;

	/** The user name. */
	@Value("${mysql.username}")
	private String userName;

	/** The password. */
	@Value("${mysql.password}")
	private String password;

	/** The hibernte dialet. */
	@Value("${hibernate.dialet}")
	private String hibernteDialet;

	/** The hibernate show sql. */
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	/** The hibernage hbm ddl auto. */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernageHbmDdlAuto;

	/** The hibernate lazy load. */
	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String hibernateLazyLoad;

	/** The hibernate etities. */
	@Value("${hibernate.entity}")
	private String hibernateEtities;

	/**
	 * Entity manager factory.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 * @throws PropertyVetoException the property veto exception
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		final LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		lcemf.setDataSource(this.getDataSource());
		lcemf.setPackagesToScan(new String[] { this.hibernateEtities });
		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		lcemf.setJpaVendorAdapter(vendorAdapter);
		lcemf.setJpaProperties(this.additionalProperties());
		return lcemf;
	}

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 * @throws PropertyVetoException the property veto exception
	 */
	@Bean
	public DataSource getDataSource() throws PropertyVetoException {

		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(this.mysqlDriver);
		dataSource.setUrl(this.jdbcURL);
		dataSource.setUsername(this.userName);
		dataSource.setPassword(this.password);
		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @param emf the emf
	 * @return PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	/**
	 * Exception translation.
	 *
	 * @return PersistenceExceptionTranslationPostProcessor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Additional properties.
	 *
	 * @return Properties
	 */
	private Properties additionalProperties() {
		final Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, this.hibernteDialet);
		properties.put(AvailableSettings.SHOW_SQL, this.hibernateShowSql);
		properties.put(AvailableSettings.HBM2DDL_AUTO, this.hibernageHbmDdlAuto);
		properties.put(AvailableSettings.ENABLE_LAZY_LOAD_NO_TRANS, this.hibernateLazyLoad);
		return properties;
	}
}