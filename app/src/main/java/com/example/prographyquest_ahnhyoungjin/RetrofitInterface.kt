package com.example.prographyquest_ahnhyoungjin

import retrofit2.Call
import retrofit2.http.GET

// retrofit interface for user list. MainActivity.kt
interface RetrofitInterface {
    @GET("/users")
    fun requestAllData(): Call<List<DataModel>>
}

// retrofit interface for follower list. FollowersActivity.kt
interface RetrofitFollowerInterface{
    @GET("followers")
    fun requestAllData(): Call<List<DataModel>>
}