package com.davida.finalApp.service;


import com.davida.finalApp.model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
