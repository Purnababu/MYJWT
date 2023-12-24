package com.example.JWTPRACTICE.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JWTPRACTICE.entity.Role;

@Repository
public interface Rolerepo extends JpaRepository<Role, Long> {

}
