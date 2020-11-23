package com.lhl.demo.config;

import com.lhl.demo.entity.response.User;
import com.lhl.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("username = " + s);
        User user = userService.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("not find by username");
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        getUserRoles(authorities,user.getRole().name());
        return new org.springframework.security.core.userdetails.User(user.getName(), passwordEncoder.encode(user.getPassword()), authorities);
    }

    public void getUserRoles(List<GrantedAuthority> list, String roleStr) {
        String[] split = roleStr.split(",");
        for (String role : split) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
    }
}
