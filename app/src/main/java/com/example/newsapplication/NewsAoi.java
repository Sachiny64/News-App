package com.example.newsapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAoi {

    @GET("top-headlines")
    Call<NewsList> getHeadlineNews(
            @Query("country") String country,

            @Query("pageSize") int pages,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<NewsList> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,

            @Query("pageSize") int pages,
            @Query("apiKey") String apiKey
    );


}
