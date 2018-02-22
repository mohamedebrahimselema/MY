package com.example.selema.my.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selema on 1/30/18.
 */

public class Myoffer {


    @SerializedName("offerNumber")
    @Expose
    private Integer offerNumber;
    @SerializedName("offerName")
    @Expose
    private String offerName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("storeAddress")
    @Expose
    private String storeAddress;
    @SerializedName("storeLocation")
    @Expose
    private String storeLocation;
    @SerializedName("storeType")
    @Expose
    private String storeType;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("premier")
    @Expose
    private Boolean premier;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;

    public Integer getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(Integer offerNumber) {
        this.offerNumber = offerNumber;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getPremier() {
        return premier;
    }

    public void setPremier(Boolean premier) {
        this.premier = premier;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

}