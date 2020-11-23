package com.lhl.demo.repository;

import com.lhl.demo.entity.response.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    User findByName(String name);
}
