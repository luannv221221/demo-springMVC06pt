package com.ra.model.dao;

import com.ra.model.entity.User;

public interface UserDAO {
    boolean save(User user);
    User findByEmail(String email);
}
