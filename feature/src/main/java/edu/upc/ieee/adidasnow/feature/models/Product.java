package edu.upc.ieee.adidasnow.feature.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("recomendations")
    @Expose
    private List<Recomendation> recomendations = null;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recomendation> getRecomendations() {
        return recomendations;
    }

    public void setRecomendations(List<Recomendation> recomendations) {
        this.recomendations = recomendations;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}}