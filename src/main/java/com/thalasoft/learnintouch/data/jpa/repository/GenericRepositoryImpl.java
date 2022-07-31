package com.thalasoft.learnintouch.data.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;

@Repository
@Transactional
public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements GenericRepository<T, ID> {

	private EntityManager entityManager;
	
	public GenericRepositoryImpl(JpaEntityInformation<T, ID> entityMetadata, EntityManager entityManager) {
		super(entityMetadata, entityManager);

        this.entityManager = entityManager;
	}
	
	public GenericRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);

		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
	    return entityManager;
	}
	
	@Override
	@Transactional
	public T deleteById(ID id) throws EntityNotFoundException {
		T entity = findOne(id);
		if (entity != null) {
			delete(entity);
		} else {
			throw new EntityNotFoundException("The entity could not be found and was not deleted");
		}
		return entity;
	}

}
