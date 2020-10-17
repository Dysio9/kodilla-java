package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
   private final int userID;
   private final String userName;
   private final char sex;
   private final LocalDate dateOfBirth;
   private final int postsNumber;

    public ForumUser(final int userID, final String userName, final char sex, final LocalDate dateOfBirth, final int postsNumber) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsNumber = postsNumber;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
