package com.team.alwiscruise.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region {
    @SerializedName( "id" )
    @Expose
    private String id;

    @SerializedName( "name" )
    @Expose
    private String name;

    @SerializedName( "image" )
    @Expose
    private int image;

    public Region(String id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
