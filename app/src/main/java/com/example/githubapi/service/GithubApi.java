package com.example.githubapi.service;

import com.example.githubapi.ApiListener;
import com.example.githubapi.model.User;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//TODO 6, buat package service, class GithubAPI
//TODO 8, ngoding disini
public class GithubApi {
    private Retrofit retrofit = null;
    private static final String URL_BASE = "https://api.github.com/";

    public GithubInterface getAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(GithubInterface.class);
    }

    //TODO 12
    public void getAllUser(final ApiListener<ArrayList<User>> listener){
        int random = new Random().nextInt(10000);
        getAPI().getUsers(random).enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                ArrayList<User> listUser = response.body();
                if (listUser != null) {
                    listener.onSuccess(listUser);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    //TODO 21, code
    public void getDetailUser(final ApiListener<User> listener, String username) {
        getAPI().getDetailUser(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (user != null){
                    listener.onSuccess(user); //kayak return, jika success ngirim datanya
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
