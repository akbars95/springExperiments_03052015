package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Tag;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface TagDAO {

    public boolean saveOrUpdateTag(Tag tag);

    public boolean deleteTag(Integer tagId);

    public Tag getTag(Integer tagId);

    public List<Tag> getAllTag();

}