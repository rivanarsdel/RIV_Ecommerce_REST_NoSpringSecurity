package dev.riv.REST_TurboBasic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
Relevant Helper Models
UserAddress
 */
@Entity
@Table(name = "ecommerce_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "hash", nullable = false)
    String userHash;

    @Column(name = "display_name")
    String displayName;
    @Column(name = "profile_picture")
    String profilePicture;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "role", nullable = false)
    String role;
    @Column(name = "dollar_balance")
    double dollarBalance;
}

