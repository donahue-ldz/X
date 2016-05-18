package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicFavoriteManager;
import com.X.biz.exception.XException;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.TopicFavoriteDO;
import com.X.dal.mapper.TopicFavoriteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Author zhong.zhou
 * Date 5/17/16
 * Email qnarcup@gmail.com
 */
@Service("topicFavoriteManager")
@Transactional(rollbackFor = Exception.class)
public class TopicFavoriteManager implements ITopicFavoriteManager {
    @Resource
    private TopicFavoriteMapper topicFavoriteMapper;

    @Override
    public long save(final TopicFavoriteDO topicFavorite) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                topicFavoriteMapper.save(topicFavorite);
                return topicFavorite.getId();
            }
        }, topicFavorite);
    }

    @Override
    public boolean update(final long id, final int status) throws XException {
        return RunWrapper.run(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                int result = topicFavoriteMapper.update(id, status);
                return result==1;
            }
        });
    }

    @Override
    public long countFavoritesByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicFavoriteMapper.countFavoritesByTopicID(topicID);
            }
        });
    }
}
