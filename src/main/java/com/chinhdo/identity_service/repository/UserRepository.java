package com.chinhdo.identity_service.repository;

import com.chinhdo.identity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username); //spring tu hieu la check su ton tai cua username trong table

    Optional<User> findByUsername(String username); //spring tu tim username
}
