package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.NewsEditor;
import com.thalasoft.learnintouch.data.jpa.domain.NewsHeading;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;

public interface NewsStoryRepository extends GenericRepository<NewsStory, Long>, NewsStoryRepositoryCustom {

    @Query("SELECT ns FROM NewsStory ns WHERE ns.newsPaper = :newsPaper AND (ns.newsHeading = :newsHeading OR (ns.newsHeading IS NULL AND :newsHeading < '1')) AND ns.listOrder = :listOrder ORDER BY ns.listOrder DESC")
    public List<NewsStory> findByListOrder(@Param("newsPaper") NewsPaper newsPaper, @Param("newsHeading") NewsHeading newsHeading, @Param("listOrder") int listOrder);

    @Query("SELECT COUNT(DISTINCT ns1.id) as count FROM NewsStory ns1, NewsStory ns2 WHERE ns1.id != ns2.id AND ns1.newsPaper.id = ns2.newsPaper.id AND ns1.newsHeading.id = ns2.newsHeading.id AND ns1.listOrder = ns2.listOrder AND ns1.newsPaper = :newsPaper AND (ns1.newsHeading = :newsHeading OR (ns1.newsHeading IS NULL AND :newsHeading < '1'))")
    public Long countDuplicateListOrders(@Param("newsPaper") NewsPaper newsPaper, @Param("newsHeading") NewsHeading newsHeading);
    
    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsPaper = :newsPaper ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsPaper(@Param("newsPaper") NewsPaper newsPaper);
    
    @Query("SELECT ns FROM NewsStory ns WHERE ns.newsHeading = :newsHeading OR (ns.newsHeading IS NULL AND :newsHeading < '1') ORDER BY ns.listOrder")
    public NewsStory findByNewsHeading(@Param("newsHeading") NewsHeading newsHeading);

    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsEditor = :newsEditor OR (ns.newsEditor IS NULL AND :newsEditor < '1') ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsEditor(@Param("newsEditor") NewsEditor newsEditor);

    @Query("SELECT ns FROM NewsStory ns WHERE ns.newsPaper = :newsPaper AND (ns.newsHeading = :newsHeading OR (ns.newsHeading IS NULL AND :newsHeading < '1')) ORDER BY ns.listOrder")
    public NewsStory findByNewsPaperAndNewsHeading(@Param("newsPaper") NewsPaper newsPaper, @Param("newsHeading") NewsHeading newsHeading);

    @Query("SELECT ns FROM NewsStory ns WHERE ns.newsPaper = :newsPaper AND (ns.newsHeading = :newsHeading OR (ns.newsHeading IS NULL AND :newsHeading < '1')) ORDER BY ns.id")
    public NewsStory findByNewsPaperAndNewsHeadingOrderById(@Param("newsPaper") NewsPaper newsPaper, @Param("newsHeading") NewsHeading newsHeading);

    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsPaper = :newsPaper AND (ns.newsEditor = :newsEditor OR (ns.newsEditor IS NULL AND :newsEditor < '1')) ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsPaperAndNewsEditor(@Param("newsPaper") NewsPaper newsPaper, @Param("newsEditor") NewsEditor newsEditor);

    @Query("SELECT ns FROM NewsStory ns WHERE ns.newsPaper = :newsPaper AND (ns.newsHeading = :newsHeading OR (ns.newsHeading IS NULL AND :newsHeading < '1')) AND (ns.newsEditor = :newsEditor OR (ns.newsEditor IS NULL AND :newsEditor < '1')) ORDER BY ns.listOrder")
    public NewsStory findByNewsPaperAndNewsHeadingAndNewsEditor(@Param("newsPaper") NewsPaper newsPaper, @Param("newsHeading") NewsHeading newsHeading, @Param("newsEditor") NewsEditor newsEditor);

    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsPaper = :newsPaper AND ((ns.releaseDate IS NOT NULL AND ns.archiveDate IS NOT NULL AND DATE(ns.releaseDate) <= :systemDate AND DATE(ns.archiveDate) >= :systemDate) OR (ns.releaseDate IS NOT NULL AND ns.archiveDate IS NULL AND DATE(ns.releaseDate) <= :systemDate) OR (ns.releaseDate IS NULL AND ns.archiveDate IS NOT NULL AND DATE(ns.archiveDate) >= :systemDate)) ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsPaperAndCurrent(@Param("newsPaper") NewsPaper newsPaper, @Param("systemDate") String systemDate);

    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsPaper = :newsPaper AND ns.archiveDate IS NOT NULL AND DATE(ns.archiveDate) < :systemDate ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsPaperAndArchived(@Param("newsPaper") NewsPaper newsPaper, @Param("systemDate") String systemDate);

    @Query("SELECT ns FROM NewsStory ns, NewsHeading nh WHERE (ns.newsHeading.id = nh.id OR ns.newsHeading IS NULL) AND ns.newsPaper = :newsPaper AND ns.releaseDate IS NOT NULL AND DATE(ns.releaseDate) > :systemDate ORDER BY nh.listOrder, ns.listOrder")
    public NewsStory findByNewsPaperAndDeferred(@Param("newsPaper") NewsPaper newsPaper, @Param("systemDate") String systemDate);

    @Query("SELECT ns FROM NewsStory ns WHERE LOWER(ns.headline) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(ns.excerpt) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR ns.releaseDate LIKE CONCAT('%', :searchTerm, '%') ORDER BY ns.headline")
    public Page<NewsStory> search(@Param("searchTerm") String searchTerm, Pageable page);

    public List<NewsStory> findByAudio(String audio);

    @Query("SELECT ns FROM NewsStory ns WHERE ns.excerpt LIKE CONCAT('%', :image, '%')")
    public List<NewsStory> findExcerptLikeImage(@Param("image") String image);

}

