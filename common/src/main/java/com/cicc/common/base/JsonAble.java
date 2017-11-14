package com.cicc.common.base;


import com.google.gson.Gson;


public class JsonAble {
    protected static final Gson gson = new Gson();

    public String toString() {
        return gson.toJson(this);
    }
}
