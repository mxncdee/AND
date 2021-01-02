package com.univaq.mwt.headlines.api;

import com.univaq.mwt.headlines.Model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("top-headlines?country=it")
    Call<News> getNews(@Query("category") String category,
                       @Query("apiKey") String apiKey
    );


    @GET("http://newsapi.org/v2/top-headlines?country=it&apiKey=1b2513f673b14577b9f252abd09b0b52")
    Call<News> getNews();
}
