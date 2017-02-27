package com.pokegames.web.model.request;

/**
 * Created by jeffreypthomas on 2/24/17.
 */
public class MovieEntity {

    private Type type;
    private String name;


    public Type getType() {

        return type;
    }

    public void setType(Type type) {

        this.type = type;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
