package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.ContactReferer;

public interface ContactRefererRepository extends GenericRepository<ContactReferer, Long>, ContactRefererRepositoryCustom {

    @Query("SELECT cr FROM ContactReferer cr ORDER BY cr.listOrder")
    public Page<ContactReferer> findThemAll(Pageable page);

    @Query("SELECT cr FROM ContactReferer cr ORDER BY cr.id")
    public List<ContactReferer> findAllOrderById();

    @Query("SELECT cr FROM ContactReferer cr WHERE cr.listOrder = :listOrder")
    public List<ContactReferer> findByListOrder(@Param("listOrder") int listOrder);

    @Query("SELECT COUNT(DISTINCT cr1.id) as count FROM ContactReferer cr1, ContactReferer cr2 WHERE cr1.id != cr2.id AND cr1.listOrder = cr2.listOrder")
    public Long countDuplicateListOrders();

}
