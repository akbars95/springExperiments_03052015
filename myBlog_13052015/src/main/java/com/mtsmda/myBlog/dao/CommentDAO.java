package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Comment;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface CommentDAO {

    public boolean saveOrUpdateComment(Comment comment);

    public boolean deleteComment(Integer commentId);

    public Comment getComment(Integer commentId);

    public List<Comment> getAllComment();

}