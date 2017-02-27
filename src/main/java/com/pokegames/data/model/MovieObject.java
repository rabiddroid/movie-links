package com.pokegames.data.model;

/**
 * Created by jeffreypthomas on 2/21/17.
 */
public class MovieObject {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MovieObject.class);

    private String name;

    public MovieObject(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
