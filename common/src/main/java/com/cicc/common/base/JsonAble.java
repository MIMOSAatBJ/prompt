package com.cicc.common.base;


import com.google.gson.Gson;


public interface JsonAble {
    Gson gson = new Gson();

    default String toJson() {
        return gson.toJson(this);
    }
}
