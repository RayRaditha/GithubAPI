package com.example.githubapi.model;

import android.os.Parcel;
import android.os.Parcelable;

//TODO 5, buat package model dan class user, ngoding disini
//TODO 23, implement parcelable
public class User implements Parcelable {
    //TODO 18, tambah id
    //private String id;
    private String login;
    private String avatar_url;
    //TODO 17, tambah data, nama setelah sting harus sama dengan yang ada di API
    private String name;
    private String public_repos;
    private String followers;
    private String following;

    //TODO 19, add getter and setter nya id,name,public repos,followers,following

    //TODO 24, muncul parcel setelah alt enter di public class User
    protected User(Parcel in) {
        login = in.readString();
        avatar_url = in.readString();
        name = in.readString();
        public_repos = in.readString();
        followers = in.readString();
        following = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeString(avatar_url);
        parcel.writeString(name);
        parcel.writeString(public_repos);
        parcel.writeString(followers);
        parcel.writeString(following);
    }
}
