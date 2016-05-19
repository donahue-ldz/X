package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ICommentFavoriteManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.CommentFavoriteDO;
import com.X.dal.mapper.CommentFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 9:19 PM
 **/
@Service("commentFavoriteManager")
@Transactional(rollbackFor = Exception.class)
public class CommentFavoriteManager implements ICommentFavoriteManager {
    @Autowired
    private CommentFavoriteMapper commentFavoriteMapper;

    @Override
    public long save(final CommentFavoriteDO commentFavoriteDO) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                commentFavoriteMapper.save(commentFavoriteDO);
                return commentFavoriteDO.getId();
            }
        }, commentFavoriteDO);
    }

    @Override
    public long countFavoritesByCommentID(final Long commentID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return commentFavoriteMapper.countFavoritesByCommentID(commentID);
            }
        });
    }
}
