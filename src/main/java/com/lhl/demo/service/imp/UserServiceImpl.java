package com.lhl.demo.service.imp;

import com.lhl.demo.entity.response.User;
import com.lhl.demo.repository.UserRepository;
import com.lhl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }
}
