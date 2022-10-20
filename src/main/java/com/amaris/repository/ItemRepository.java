package com.amaris.repository;

import com.amaris.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    Page<ItemEntity> findAll(Pageable pageable);
}
