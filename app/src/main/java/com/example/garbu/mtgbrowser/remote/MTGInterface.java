package com.example.garbu.mtgbrowser.remote;


import com.example.garbu.mtgbrowser.model.CardList;
import com.example.garbu.mtgbrowser.model.MTGSets;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by garbu on 9/3/2018.
 */

public interface MTGInterface {

    //get list of sets
    @GET("v1/sets")
    Call<MTGSets> getSets(@Query("type") String types);

    //get cards for selected set
    @GET("v1/cards")
    Call<CardList> getCards(@Query("set") String set, @Query("page") int page);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.magicthegathering.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
