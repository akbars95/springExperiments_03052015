package com.mtsmda.myBlog.model;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class Tag {

    private Integer idTag;
    private String tagName;

    public Tag() {

    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}