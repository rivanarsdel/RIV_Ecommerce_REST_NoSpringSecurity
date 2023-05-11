package dev.riv.REST_TurboBasic.modelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    int userId;
    String userHash;
    String displayName;
    String profilePicture;
    String email;
    String password;
    String role;
    double dollarBalance;

//    public UserDTO() {
//    }
//
//    public UserDTO(int userId, String userHash, String displayName, String profilePicture, String email, String password, String role, double dollarBalance) {
//        this.userId = userId;
//        this.userHash = userHash;
//        this.displayName = displayName;
//        this.profilePicture = profilePicture;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//        this.dollarBalance = dollarBalance;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
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
