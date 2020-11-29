package com.example.githubapi.service;

import com.example.githubapi.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

//Todo 7, buat GithubInterface, untuk pemanggilan
//TODO 9, ngoding disini
public interface GithubInterface {

    @GET("users?") //tanda tanya ini namanya query
    Call<ArrayList<User>> getUsers(@Query("since") int random);

    //TODO 20, add code
    @GET("users/{username}") //kurung siku (kurawal) namanya path
    Call<User> getDetailUser(@Path("username") String username);
}
