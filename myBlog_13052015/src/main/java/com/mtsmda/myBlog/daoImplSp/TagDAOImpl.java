package com.mtsmda.myBlog.daoImplSp;

import com.mtsmda.myBlog.dao.TagDAO;
import com.mtsmda.myBlog.model.Tag;

import java.util.List;

/**
 * Created by c-DMITMINZ on 02.07.2015.
 */
public class TagDAOImpl implements TagDAO {

    @Override
    public boolean saveOrUpdateTag(Tag tag) {
        return false;
    }

    @Override
    public boolean deleteTag(Integer tagId) {
        return false;
    }

    @Override
    public Tag getTag(Integer tagId) {
        return null;
    }

    @Override
    public List<Tag> getAllTag() {
        return null;
    }

}