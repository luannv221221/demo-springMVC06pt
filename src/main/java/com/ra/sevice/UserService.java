package com.ra.sevice;

import com.ra.model.entity.User;

public interface UserService {
    boolean register(User user);
    boolean login(String email,String password);
}
