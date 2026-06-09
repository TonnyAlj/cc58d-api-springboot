package com.solenfrio.apicore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.solenfrio.apicore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);

    public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
