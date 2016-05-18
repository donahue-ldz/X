package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ICommentManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.CommentDO;
import com.X.dal.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
@Service("commentManager")
@Transactional(rollbackFor = Exception.class)
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
    public CommentDO queryCommentByID(@NotNull final Long id) throws XException {
        return RunWrapper.run(new Callable<CommentDO>() {
            @Override
            public CommentDO call() throws Exception {
                return commentMapper.queryCommentByID(id);
            }
        });
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

    @Override
    public long countCommentsByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return commentMapper.countCommentsByTopicID(topicID);
            }
        });
    }
}
