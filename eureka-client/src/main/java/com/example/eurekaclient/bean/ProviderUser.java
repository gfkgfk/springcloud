package com.example.eurekaclient.bean;

import java.io.Serializable;

public class ProviderUser implements Serializable {
    private static final long serialVersionUID = 1L;
    String id;
    String name;
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
