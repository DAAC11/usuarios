package com.desaextremo.retouno.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario",indexes = @Index(name="indx_email",columnList = "user_email", unique = true))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_email",nullable = false,length = 50)
    private String email;
    @Column(name="user_password",nullable = false,length = 50)
    private String password;
    @Column(name="user_name",nullable = false,length = 80)
    private String name;
}
