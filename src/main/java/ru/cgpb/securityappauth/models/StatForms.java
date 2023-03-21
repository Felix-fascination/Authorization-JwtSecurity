package ru.cgpb.securityappauth.models;

import java.io.Serializable;

public class StatForms implements Serializable {
    String id;
    String name;

    public StatForms(String id, String name) {
        this.id = id;
        this.name = name;
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
}
