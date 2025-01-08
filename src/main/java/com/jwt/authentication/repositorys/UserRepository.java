package com.jwt.authentication.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.authentication.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
