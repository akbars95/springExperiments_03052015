package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.CommentDAO;
import com.mtsmda.myBlog.model.Comment;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class CommentDAOImpl implements CommentDAO {

    @Override
    public boolean saveOrUpdateComment(Comment comment) {
        return false;
    }

    @Override
    public boolean deleteComment(Integer commentId) {
        return false;
    }

    @Override
    public Comment getComment(Integer commentId) {
        return null;
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }
    
}