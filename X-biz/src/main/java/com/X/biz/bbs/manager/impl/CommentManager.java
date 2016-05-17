package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.exception.XException;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.CommentDO;
import com.X.dal.mapper.CommentMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
public class CommentManager implements ICommentManager {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public long save(final CommentDO comment) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                commentMapper.save(comment);
                return comment.getId();
            }
        }, comment);
    }

    @Override
    public List<CommentDO> queryCommentsByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<List<CommentDO>>() {
            @Override
            public List<CommentDO> call() throws Exception {
                return commentMapper.queryCommentsByTopicID(topicID);
            }
        });
    }
}
