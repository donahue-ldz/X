package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CommentDO;

import java.util.List;

/**
 * Created by donahue on 5/10/16.
 */
public interface ICommentManager {
    long save(CommentDO comment) throws XException;
    List<CommentDO> queryCommentsByTopicID(long topicID) throws XException;

}
