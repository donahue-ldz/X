package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicRateManager;
import com.X.biz.constant.status.RateType;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicRateDO;
import com.X.dal.mapper.TopicRateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Author zhong.zhou
 * Date 5/17/16
 * Email qnarcup@gmail.com
 */
@Service("topicRateManager")
@Transactional(rollbackFor = Exception.class)
public class TopicRateManager implements ITopicRateManager {
    @Resource
    private TopicRateMapper topicRateMapper;

    @Override
    public long save(final TopicRateDO topicRate) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                if (!topicRate.getRateType().equals(RateType.View.SQLValue())) {
                    TopicRateDO topicRateDO = topicRateMapper.queryTopicRate(topicRate.getTopicID(), topicRate.getUserID(), topicRate.getRateType());
                    if (topicRateDO != null) throw new XException("已经操作过...不能再次操作");
                }
                topicRateMapper.save(topicRate);
                return topicRate.getId();
            }
        }, topicRate);
    }

    @Override
    public boolean update(final long id, final RateType rateType, final String status) throws XException {
        return RunWrapper.run(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                int result = topicRateMapper.update(id, rateType.SQLValue(), status);
                return result == 1;
            }
        });
    }

    @Override
    public TopicRateDO queryTopicRate(final Long topicID, final Long userID, final RateType rateType) throws XException {
        return RunWrapper.run(new Callable<TopicRateDO>() {
            @Override
            public TopicRateDO call() throws Exception {
                return topicRateMapper.queryTopicRate(topicID, userID, rateType.SQLValue());
            }
        });
    }

    @Override
    public List<TopicRateDO> queryTopicRatesByUser(final Long topicID, final Long userID) throws XException {
        return RunWrapper.run(new Callable<List<TopicRateDO>>() {
            @Override
            public List<TopicRateDO> call() throws Exception {
                return topicRateMapper.queryTopicRatesByUser(topicID, userID);
            }
        });
    }

    @Override
    public long countFavoritesByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countFavoritesByTopicID(topicID);
            }
        });
    }

    @Override
    public long countViewsByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countViewsByTopicID(topicID);
            }
        });
    }

    @Override
    public long countBookmarksByTopicID(final long topicID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countBookmarksByTopicID(topicID);
            }
        });
    }

    @Override
    public long countFavoritesByUserID(final Long userID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countFavoritesByUserID(userID);
            }
        });
    }

    @Override
    public long countViewsByUserID(final Long userID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countViewsByUserID(userID);
            }
        });
    }

    @Override
    public long countBookmarksByUserID(final Long userID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicRateMapper.countBookmarksByUserID(userID);
            }
        });
    }
}
