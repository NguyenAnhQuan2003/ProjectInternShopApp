package com.projectwebintern.dodungchatluon.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "social_accounts")
@Getter
@Setter
public class SocialAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider", length = 20, nullable = false)
    private String provider;

    @Column(name = "provider_Id", length = 50, nullable = false)
    private String providerId;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "name", length = 50)
    private String name;

//    @Column(name = "user_id")
//    private int userId;
}
