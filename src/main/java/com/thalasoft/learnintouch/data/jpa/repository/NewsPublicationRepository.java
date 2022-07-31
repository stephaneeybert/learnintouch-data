package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.NewsPublication;

public interface NewsPublicationRepository extends GenericRepository<NewsPublication, Long> {

    @Query("SELECT np FROM NewsPublication np ORDER BY np.name")
    public Page<NewsPublication> findThemAll(Pageable page);

    @Query("SELECT np FROM NewsPublication np WHERE LOWER(np.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY np.name")
    public Page<NewsPublication> search(@Param("searchTerm") String searchTerm, Pageable page);
    
    @Query("SELECT np FROM NewsPublication np WHERE np.name = :name")
    public NewsPublication findByName(@Param("name") String name);

}

