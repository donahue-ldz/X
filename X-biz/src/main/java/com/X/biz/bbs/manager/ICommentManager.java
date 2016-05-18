package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CommentDO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by donahue on 5/10/16.
 */
public interface ICommentManager {
    long save(CommentDO comment) throws XException;
    CommentDO queryCommentByID(@NotNull Long id) throws XException;
    List<CommentDO> queryCommentsByTopicID(long topicID) throws XException;
    long countCommentsByTopicID(long topicID) throws XException;

}
