package com.example.cameronmcintyre.cpmcinty_subapp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cameronmcintyre on 2018-02-04.
 */

public class Subscription implements Serializable{
    private String Name;
    private Date date;
    private Double charge;
    private String comment;

    public Subscription(String name, Date date, Double charge) {
        Name = name;
        this.date = date;
        this.charge = charge;
        comment = "";
    }

    public Subscription(String name, Date date, Double charge, String comment) {
        Name = name;
        this.date = date;
        this.charge = charge;
        this.comment = comment;
    }
    public Subscription(String name, Double charge){
        Name = name;
        date = new Date();
        this.charge = charge;
        this.comment ="";
    }
    public Subscription( String name, Double charge, String comment){
        Name = name;
        date = new Date();
        this.charge = charge;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "Subcription Name: '" + Name + '\'' +
                ", Add date: " + date +
                ", charge:$" + charge +
                ", comment:'" + comment + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

