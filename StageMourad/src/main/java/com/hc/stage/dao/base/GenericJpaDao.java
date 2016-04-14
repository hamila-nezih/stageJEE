package com.hc.stage.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.hc.stage.entities.base.BaseEntity;

/**
 * Provides generic common implementation of GenericDao interface persistence methods.
 * Extend this abstract class to implement DAO for your specific needs.
 * 
 * @author Arthur Vin
 */
@Transactional
public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {
	@PersistenceContext
	private EntityManager em ;
	private Class<T> persistentClass;
	
	private EntityManager entityManager;
	
	public GenericJpaDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Transactional(readOnly=true)
	public T findById(ID id) {
		T entity = em.find(getPersistentClass(), id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> select() {
		return em
			.createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
			.getResultList();
	}
	
	public T ajouter(T entity) {
		em.persist(entity);
		return entity;
	}
	
	public T update(T entity) {
		T mergedEntity = em.merge(entity);
		return mergedEntity;
	}
	
	public void delete(T entity) {
		if (BaseEntity.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(), 
							((BaseEntity)entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
	}
	
	public void flush() {
		em.flush();
	}
	
}
