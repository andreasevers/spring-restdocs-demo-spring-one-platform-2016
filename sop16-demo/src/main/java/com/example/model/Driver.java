package com.example.model;

import org.springframework.hateoas.ResourceSupport;

public class Driver extends ResourceSupport {

    private long id;

    private String name;

    public Driver() {}

    public Driver(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String brand) {
        this.name = name;
    }

}
