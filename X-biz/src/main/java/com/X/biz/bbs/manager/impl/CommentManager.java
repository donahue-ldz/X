package com.X.biz.bbs.manager.impl;

import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.CommentDO;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
public class CommentManager implements ICommentManager {
    @Override
    public long save(CommentDO comment) throws XException {
        return 0;
    }

    @Override
    public List<CommentDO> queryCommentsByTopicID(long topicID) throws XException {
        return null;
    }
}
