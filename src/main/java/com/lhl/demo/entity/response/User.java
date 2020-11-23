package com.lhl.demo.entity.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        admin, normal
    }
}
