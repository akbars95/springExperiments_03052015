package com.mtsmda.myBlog.model;

import java.util.GregorianCalendar;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class Comment {

    private Integer idComment;
    private Author author;
    private GregorianCalendar commentCreatedDate;
    private String commentText;

    public Comment() {

    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public GregorianCalendar getCommentCreatedDate() {
        return commentCreatedDate;
    }

    public void setCommentCreatedDate(GregorianCalendar commentCreatedDate) {
        this.commentCreatedDate = commentCreatedDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}