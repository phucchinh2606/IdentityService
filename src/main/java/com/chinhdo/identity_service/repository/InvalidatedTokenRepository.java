package com.chinhdo.identity_service.repository;

import com.chinhdo.identity_service.entity.InvalidateToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidateToken,String> {
}
