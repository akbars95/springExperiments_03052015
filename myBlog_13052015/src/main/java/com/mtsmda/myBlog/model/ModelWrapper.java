package com.mtsmda.myBlog.model;

import java.util.List;

/**
 * Created by c-DMITMINZ on 08.07.2015.
 */
public class ModelWrapper<T> {

    List<T> list;

    public ModelWrapper() {

    }

    public ModelWrapper(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}