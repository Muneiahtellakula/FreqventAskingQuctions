package com.muneiah.example.helloworld;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitService {
    //public static final  String BASEURL="https://www.googleapis.com/";
    public static final  String BASEURL="https://raw.githubusercontent.com";
   // public static final  String BASEURL="https://api.covid19api.com/";
    static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
