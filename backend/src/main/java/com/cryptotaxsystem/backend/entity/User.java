package com.cryptotaxsystem.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)  // password_hash -> password로 변경
    private String password;  // passwordHash -> password로 변경

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "join_date", nullable = false)
    private LocalDateTime joinDate;
}
