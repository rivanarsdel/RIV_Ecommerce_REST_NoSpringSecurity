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
//
//    public User() {
//    }
//
//    public User(int id, String userHash, String displayName, String profilePicture, String email, String password, String role, double dollarBalance) {
//        this.id = id;
//        this.userHash = userHash;
//        this.displayName = displayName;
//        this.profilePicture = profilePicture;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.dollarBalance = dollarBalance;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUserHash() {
//        return userHash;
//    }
//
//    public void setUserHash(String userHash) {
//        this.userHash = userHash;
//    }
//
//    public String getDisplayName() {
//        return displayName;
//    }
//
//    public void setDisplayName(String displayName) {
//        this.displayName = displayName;
//    }
//
//    public String getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(String profilePicture) {
//        this.profilePicture = profilePicture;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public double getDollarBalance() {
//        return dollarBalance;
//    }
//
//    public void setDollarBalance(double dollarBalance) {
//        this.dollarBalance = dollarBalance;
//    }
}

