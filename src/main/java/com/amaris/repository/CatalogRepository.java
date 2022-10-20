package com.amaris.repository;

import com.amaris.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, String> {

    @Query(value = "select id from catalog\n" +
            "where id = :catalogId", nativeQuery = true)
    String findByCatalogId(@Param("catalogId") String catalogId);
}
