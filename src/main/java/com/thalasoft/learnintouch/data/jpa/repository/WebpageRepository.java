package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.Webpage;

public interface WebpageRepository extends GenericRepository<Webpage, Long>, WebpageRepositoryCustom {
    
    @Query("SELECT w FROM Webpage w ORDER BY w.name")
    public Page<Webpage> findThemAll(Pageable page);

    @Query("SELECT w FROM Webpage w WHERE w.parent = :parent OR (parent IS NULL AND :parent IS NULL)) ORDER BY w.listOrder")
    public Page<Webpage> findByParent(@Param("parent") Webpage parent, Pageable page);

    @Query("SELECT w FROM Webpage w WHERE w.parent = :parent OR (parent IS NULL AND :parent < '1') ORDER BY w.id")
    public Page<Webpage> findByParentOrderById(@Param("parent") Webpage parent, Pageable page);

    @Query("SELECT w FROM Webpage w WHERE w.parent = :parent OR (parent IS NULL AND :parent < '1') AND w.name = :name")
    public Webpage findByParentAndName(@Param("parent") Webpage parent, @Param("name") String name);

    @Query("SELECT w FROM Webpage w WHERE w.parent = :parent OR (parent IS NULL AND :parent < '1') AND w.name = :name AND w.garbage != '1'")
    public Webpage findByParentAndNameAndNotGarbage(@Param("parent") Webpage parent, @Param("name") String name);

    @Query("SELECT w FROM Webpage w WHERE w.admin = :admin ORDER BY w.name")
    public Page<Webpage> findByAdmin(@Param("admin") Admin admin, Pageable page);

    @Query("SELECT w FROM Webpage w WHERE w.garbage = '1' ORDER BY w.name")
    public Page<Webpage> findGarbage(Pageable page);

    @Query("SELECT w FROM Webpage w WHERE w.garbage != '1' ORDER BY w.name")
    public Page<Webpage> findNonGarbage(Pageable page);
    
    @Query("SELECT w FROM Webpage w WHERE w.content LIKE CONCAT('%', :image, '%')")
    public List<Webpage> findByImage(String image);

    @Query("SELECT w FROM Webpage w WHERE LOWER(w.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(w.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(w.content) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY w.name")
    public Page<Webpage> search(@Param("searchTerm") String searchTerm, Pageable page);

    @Query("SELECT w FROM Webpage w WHERE (w.parent = :parent OR (w.parent IS NULL AND :parent < '1')) AND w.listOrder = :listOrder ORDER BY w.listOrder DESC")
    public Page<Webpage> findByListOrder(@Param("parent") Webpage parent, @Param("listOrder") int listOrder, Pageable page);

    @Query("SELECT COUNT(DISTINCT w1.id) as count FROM Webpage w1, Webpage w2 WHERE w1.id != w2.id AND w1.parent.id = w2.parent.id AND w1.listOrder = w2.listOrder AND w1.parent = :parent")
    public Long countDuplicateListOrders(@Param("parent") Webpage parent);

}
