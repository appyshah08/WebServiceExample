package com.example.dhaval.webserviceexample.pojo;

/**
 * Created by dhaval on 10/2/17.
 */

public class UserInfo {
    String id;
    String userName;
    int userProfilePicture;
    String userDob;
    String userPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(int userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
