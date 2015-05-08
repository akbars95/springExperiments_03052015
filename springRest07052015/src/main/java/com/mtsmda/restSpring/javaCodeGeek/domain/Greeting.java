package com.mtsmda.restSpring.javaCodeGeek.domain;

/**
 * Created by dmitriim on 5/8/2015.
 */
public class Greeting {
    private long id;
    private String content;

    public Greeting() {

    }

    public Greeting(String content) {
        this.content = content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
