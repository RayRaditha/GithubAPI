package com.example.githubapi;

import com.example.githubapi.model.User;

import java.util.ArrayList;

//TODO 10, refactor rename GithubAPI jdi GithubApi
//TODO 11, buat class ApiListener, ubah public class jdi public interface
public interface ApiListener<T> {
    void onSuccess(T users);
    void onFailed(String msg);
}
//T berdasarkan tipe data, jadi dia dinamis datanya
