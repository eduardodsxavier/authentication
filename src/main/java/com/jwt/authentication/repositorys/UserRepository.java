package com.jwt.authentication.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwt.authentication.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.name = %?1 AND u.password = %?2")
    User findUser(String name, int password);

    @Query("SELECT u FROM User u WHERE u.jwt = %?1")
    User findJwt(String jwt);
}
