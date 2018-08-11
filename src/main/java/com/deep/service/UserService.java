package com.deep.service;

import java.util.List;

import com.deep.model.User;

public interface UserService {

	User save(User user);

    List<User> findAll();

    void delete(long id);
}
