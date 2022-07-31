package com.thalasoft.learnintouch.data.jpa.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.thalasoft.learnintouch.data.exception.EntityNotFoundException;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
//	TODO extends PagingAndSortingRepository
	
    public EntityManager getEntityManager();
    
	public T deleteById(ID id) throws EntityNotFoundException;
	
}
