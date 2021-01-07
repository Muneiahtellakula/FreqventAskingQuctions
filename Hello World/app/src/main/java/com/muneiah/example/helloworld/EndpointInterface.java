package com.muneiah.example.helloworld;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {
   // @GET("/dayone/country/IN")
   // @GET("books/v1/volumes?q=twostates")
    @GET("/AP-Skill-Development-Corporation/AAD-STP-B1/main/Qa_Data.json")
    Call<String> getData();
}
