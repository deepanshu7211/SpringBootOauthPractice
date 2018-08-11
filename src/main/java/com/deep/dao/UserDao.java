package com.deep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deep.model.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
