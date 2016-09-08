package com.krashidbuilt.jetty.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Ben Kauffman on 9/8/2016.
 */

public class Test implements Serializable {
    private int id;
    private String name;

    public Test(){
        id = -1;
        name = "default name";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Test fromString(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Test.class);
    }
}
