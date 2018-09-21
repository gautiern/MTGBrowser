package com.example.garbu.mtgbrowser.model;

import android.arch.lifecycle.LiveData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by garbu on 9/3/2018.
 *
 */

public class MTGSets {

    @SerializedName("sets")
    @Expose
    private List<Set> sets = null;


    public MTGSets() {
        //empty constructor
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

}
