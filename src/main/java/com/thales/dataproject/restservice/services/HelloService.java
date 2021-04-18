package com.thales.dataproject.restservice.services;

public class HelloService {
    private final long id;
    private final String content;

    public HelloService(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
