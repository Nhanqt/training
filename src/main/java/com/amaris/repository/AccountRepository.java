package com.amaris.repository;

import com.amaris.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    // AccountEntity findByEmail(String email);
    Optional<AccountEntity> findByEmail(String email);

}
