package com.gymadmin.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.gymadmin.persistence.dao.Dao;


public abstract class DaoImpl<K, E> implements Dao<K, E>{

    protected Class<E> entityClass;

    protected EntityManager em = null;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	@Transactional(readOnly=false)
	public void flush() {
		em.flush();
	}

	@SuppressWarnings("unchecked")
	public DaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	@Transactional(readOnly=false)
	public void persist(E entity) {
		em.persist(entity);
	}

	@Transactional(readOnly=false)
	public void merge(E entity) {
		em.merge(entity);
	}

	@Transactional(readOnly=false)
	public void remove(E entity) {
		em.remove(entity);
	}
	
	@Transactional(readOnly=true)
	public E findById(K id) {
		return em.find(entityClass, id);
	}
	
	public void rollBack() {
		em.getTransaction().rollback();
	}
	
	@Transactional(readOnly=true)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findAll() {		
		String query = "from " + entityClass.getName() + " c";
		Query q = em.createQuery(query);
        return q.getResultList();
	}
}
