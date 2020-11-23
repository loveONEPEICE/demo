package com.lhl.demo.init;

import com.lhl.demo.entity.response.User;
import com.lhl.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
//@Service
public class DataInit {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    public void dataInit(){
        User user = new User();
        user.setName("test1");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setRole(User.Role.admin);
        userRepository.save(user);
    }
}
