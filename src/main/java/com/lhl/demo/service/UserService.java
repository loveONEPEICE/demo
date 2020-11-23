package com.lhl.demo.service;

import com.lhl.demo.entity.response.User;

public interface UserService {
    public User findByUserName(String username);
}
