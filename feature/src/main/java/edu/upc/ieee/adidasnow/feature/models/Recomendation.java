package edu.upc.ieee.adidasnow.feature.models;

/**
 * Created by alejandro on 11/03/18.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recomendation {

    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("link")
    @Expose
    private String link;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}