package com.arcsavunma.fouralabs.model.posts;

public class Posts {

    private String email, userName, userComment, photoUrl;

    public Posts(String email, String userName, String userComment, String photoUrl) {
        this.email = email;
        this.userName = userName;
        this.userComment = userComment;
        this.photoUrl = photoUrl;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
