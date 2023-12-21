package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.models.User;
@Repository
public interface UserRepositiry extends JpaRepository<User, String> {

	   User findByUserid(String userid);
}
