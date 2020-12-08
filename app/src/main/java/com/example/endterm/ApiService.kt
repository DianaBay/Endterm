package com.example.endterm

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("posts/")
    fun getPosts(): Call<List<Posts>>

    @GET("todos/{id}/")
    fun getPostsById(@Path("id") postId: Int): Call<Posts>

    @Headers("Cache-Control: max-age=640000", "User-Agent: My-App-Name")
    @GET("posts/")
    fun getPostsByUserId(
        @Query("userId") userId: Int,
        @Query("title") title: String
    ): Call<List<Posts>>


    @FormUrlEncoded
    @POST("posts/")
    fun addPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Call<Posts>

    @GET
    fun getPostsWithUrl(@Url url: String): Call<List<Posts>>
}