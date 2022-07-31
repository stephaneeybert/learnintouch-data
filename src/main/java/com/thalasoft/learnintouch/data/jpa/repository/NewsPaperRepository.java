package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPublication;

public interface NewsPaperRepository extends GenericRepository<NewsPaper, Long> {

    @Query("SELECT np FROM NewsPaper np ORDER BY np.releaseDate DESC, np.title")
    public Page<NewsPaper> findThemAll(Pageable page);

    @Query("SELECT np FROM NewsPaper np WHERE np.title = :title")
    public NewsPaper findByTitle(@Param("title") String title);

    public List<NewsPaper> findByImage(String image);

    @Query("SELECT np FROM NewsPaper np WHERE np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublication(@Param("newsPublication") NewsPublication newsPublication);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished != '1' ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndPublished(@Param("newsPublication") NewsPublication newsPublication);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished = '1' ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndNotPublished(@Param("newsPublication") NewsPublication newsPublication);

    @Query("SELECT np FROM NewsPaper np WHERE np.notPublished != '1' AND (np.releaseDate IS NOT NULL AND np.archiveDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate AND DATE(np.archiveDate) >= :systemDate) OR (np.releaseDate IS NOT NULL AND np.archiveDate IS NULL AND DATE(np.releaseDate) <= :systemDate) OR (np.releaseDate IS NULL AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) >= :systemDate)) ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findPublishedAndCurrent(@Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished != '1' AND (np.releaseDate IS NOT NULL AND np.archiveDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate AND DATE(np.archiveDate) >= :systemDate) OR (np.releaseDate IS NOT NULL AND np.archiveDate IS NULL AND DATE(np.releaseDate) <= :systemDate) OR (np.releaseDate IS NULL AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) >= :systemDate)) ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndPublishedAndCurrent(@Param("newsPublication") NewsPublication newsPublication, @Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished != '1' AND np.releaseDate IS NOT NULL AND DATE(np.releaseDate) > :systemDate ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndPublishedAndDeferred(@Param("newsPublication") NewsPublication newsPublication, @Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished != '1' AND np.releaseDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndPublishedAndRecent(@Param("newsPublication") NewsPublication newsPublication, @Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.notPublished != '1' AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) < :systemDate ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndPublishedAndArchived(@Param("newsPublication") NewsPublication newsPublication, @Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE (np.newsPublication = :newsPublication OR (np.newsPublication IS NULL AND :newsPublication < '1')) AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) < :sinceDate ORDER BY np.releaseDate DESC, np.title")
    public NewsPaper findByNewsPublicationAndArchivedSince(@Param("newsPublication") NewsPublication newsPublication, @Param("sinceDate") String sinceDate);

    @Query("UPDATE NewsPaper SET archiveDate = :systemDate WHERE (newsPublication = :newsPublication OR (newsPublication IS NULL AND :newsPublication < '1')) AND releaseDate IS NOT NULL AND archiveDate IS NULL AND DATE(releaseDate) <= :sinceDate")
    public void archivveByReleaseDate(@Param("newsPublication") NewsPublication newsPublication, @Param("sinceDate") String sinceDate, @Param("systemDate") String systemDate);

    @Query("SELECT np FROM NewsPaper np WHERE LOWER(np.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.header) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.footer) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY np.releaseDate DESC, np.title")
    public Page<NewsPaper> search(@Param("searchTerm") String searchTerm, Pageable page);

    @Query("SELECT np FROM NewsPaper np, NewsPublication npu WHERE (np.newsPublication.id = npu.id OR np.newsPublication IS NULL) AND (LOWER(np.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.header) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.footer) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(npu.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) AND np.notPublished != '1' AND (np.releaseDate IS NOT NULL AND np.archiveDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate AND DATE(np.archiveDate) >= :systemDate) OR (np.releaseDate IS NOT NULL AND np.archiveDate IS NULL AND DATE(np.releaseDate) <= :systemDate) OR (np.releaseDate IS NULL AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) >= :systemDate)) ORDER BY np.releaseDate DESC, np.title")
    public Page<NewsPaper> searchInNewsPaperAndNewspublication(@Param("searchTerm") String searchTerm, @Param("systemDate") String systemDate, Pageable page);

    @Query("SELECT np FROM NewsPaper np WHERE (LOWER(np.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.header) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.footer) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) AND np.notPublished != '1' AND (np.releaseDate IS NOT NULL AND np.archiveDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate AND DATE(np.archiveDate) >= :systemDate) OR (np.releaseDate IS NOT NULL AND np.archiveDate IS NULL AND DATE(np.releaseDate) <= :systemDate) OR (np.releaseDate IS NULL AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) >= :systemDate)) ORDER BY np.releaseDate DESC, np.title")
    public Page<NewsPaper> searchPublishedAndCurrent(@Param("searchTerm") String searchTerm, @Param("systemDate") String systemDate, Pageable page);
    
    @Query("SELECT np FROM NewsPaper np, NewsPublication npu WHERE (np.newsPublication.id = npu.id OR np.newsPublication IS NULL) AND (LOWER(np.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.header) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(np.footer) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(npu.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) AND np.notPublished != '1' AND (np.releaseDate IS NOT NULL AND np.archiveDate IS NOT NULL AND DATE(np.releaseDate) <= :systemDate AND DATE(np.archiveDate) >= :systemDate) OR (np.releaseDate IS NOT NULL AND np.archiveDate IS NULL AND DATE(np.releaseDate) <= :systemDate) OR (np.releaseDate IS NULL AND np.archiveDate IS NOT NULL AND DATE(np.archiveDate) >= :systemDate)) ORDER BY np.releaseDate DESC, np.title")
    public Page<NewsPaper> searchInNewsPaperAndNewspublicationAndPublishedAndCurrent(@Param("searchTerm") String searchTerm, @Param("systemDate") String systemDate, Pageable page);

}

