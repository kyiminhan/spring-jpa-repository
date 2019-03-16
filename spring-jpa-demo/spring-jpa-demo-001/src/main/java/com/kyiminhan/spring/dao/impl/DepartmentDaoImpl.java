package com.kyiminhan.spring.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.kyiminhan.spring.dao.DepartmentDao;
import com.kyiminhan.spring.entity.Department;

/**
 * The Class DepartmentDaoImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.dao.impl </BR>
 *        DepartmentDaoImpl.java </BR>
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.DepartmentDao#save(com.kyiminhan.spring.entity.
	 * Department)
	 */
	@Override
	public void save(final Department department) {
		this.em.persist(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.dao.DepartmentDao#update(com.kyiminhan.spring.entity.
	 * Department)
	 */
	@Override
	public void update(final Department department) {
		this.em.merge(department);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.kyiminhan.spring.dao.DepartmentDao#delete(com.kyiminhan.spring.entity.
	 * Department)
	 */
	@Override
	public void delete(final Department department) {
		this.em.remove(this.em.merge(department));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.DepartmentDao#findById(java.lang.Integer)
	 */
	@Override
	public Department findById(final Integer id) {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
		final Root<Department> root = criteria.from(Department.class);
		criteria.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(root.get("id"), id));
		criteria.where(predicates.toArray(new Predicate[0])).distinct(true);
		return this.em.createQuery(criteria).getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.kyiminhan.spring.dao.DepartmentDao#findAll()
	 */
	@Override
	public Collection<Department> findAll() {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<Department> criteria = cb.createQuery(Department.class);
		final Root<Department> root = criteria.from(Department.class);
		criteria.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		criteria.where(predicates.toArray(new Predicate[0])).distinct(true);
		return this.em.createQuery(criteria).getResultList();
	}
}