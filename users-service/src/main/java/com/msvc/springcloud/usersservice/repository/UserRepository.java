package com.msvc.springcloud.usersservice.repository;

import com.msvc.springcloud.usersservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
