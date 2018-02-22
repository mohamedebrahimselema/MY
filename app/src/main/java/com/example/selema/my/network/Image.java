package com.example.selema.my.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by selema on 2/15/18.
 */
public class Image {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imageName")
    @Expose
    private String imageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}


