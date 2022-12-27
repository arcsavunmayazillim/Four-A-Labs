package com.arcsavunma.fouralabs.model.user;

public class UserProfile {
    String userMail, userName, userSurname, userNickName, userPosts, userFollowers, userFollows, userPostUrl;

    public UserProfile(String userMail,String userName, String userSurname, String userNickName, String userPosts, String userFollowers, String userFollows, String userPostUrl) {
        this.userMail = userMail;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userNickName = userNickName;
        this.userPosts = userPosts;
        this.userFollowers = userFollowers;
        this.userFollows = userFollows;
        this.userPostUrl = userPostUrl;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(String userPosts) {
        this.userPosts = userPosts;
    }

    public String getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(String userFollowers) {
        this.userFollowers = userFollowers;
    }

    public String getUserFollows() {
        return userFollows;
    }

    public void setUserFollows(String userFollows) {
        this.userFollows = userFollows;
    }

    public String getUserPostUrl() {
        return userPostUrl;
    }

    public void setUserPostUrl(String userPostUrl) {
        this.userPostUrl = userPostUrl;
    }
}
