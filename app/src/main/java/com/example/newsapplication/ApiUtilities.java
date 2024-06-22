package com.example.newsapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    private static String baseUrl="https://newsapi.org/v2/";


    private static Retrofit retrofit = null;

    public static NewsAoi getApiInterface(){
        if (retrofit == null){

            retrofit= new  Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(NewsAoi.class);

    }
}

