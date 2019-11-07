package com.team.alwiscruise.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName( "id" )
    @Expose
    private String id;

    @SerializedName( "departure" )
    @Expose
    private String departure;

    @SerializedName( "price" )
    @Expose
    private String price;

    @SerializedName( "ship" )
    @Expose
    private String ship;

    @SerializedName( "start_date" )
    @Expose
    private String start_date;

    @SerializedName( "end_date" )
    @Expose
    private String end_date;

    public Ticket(String id, String departure, String price, String ship, String start_date, String end_date) {
        this.id = id;
        this.departure = departure;
        this.price = price;
        this.ship = ship;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
