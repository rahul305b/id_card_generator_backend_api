package com.id.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Auth")
@Entity(name = "Authentication")
@Getter
@Setter
public class Authentication extends AbstractBaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name="password")
    private String password;


}
