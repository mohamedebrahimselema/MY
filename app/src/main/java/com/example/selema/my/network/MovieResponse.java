package com.example.selema.my.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by selema on 1/30/18.
 */

public class MovieResponse {

    @SerializedName("myoffers")
    @Expose
    private List<Myoffer> myoffers = null;

    public List<Myoffer> getMyoffers() {
        return myoffers;
    }

    public void setMyoffers(List<Myoffer> myoffers) {
        this.myoffers = myoffers;
    }
}