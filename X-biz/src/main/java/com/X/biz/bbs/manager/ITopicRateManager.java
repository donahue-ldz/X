package com.X.biz.bbs.manager;

import com.X.biz.constant.status.RateType;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicRateDO;

import java.util.List;

/**
 * Author zhong.zhou
 * Date 5/17/16
 * Email qnarcup@gmail.com
 */
public interface ITopicRateManager {
    long save(TopicRateDO topicRate) throws XException;

    boolean update(long id, RateType rateType, String status) throws XException;

    TopicRateDO queryTopicRate(Long topicID, Long userID, RateType rateType) throws XException;

    List<TopicRateDO> queryTopicRatesByUser(Long topicID, Long userID) throws XException;

    long countFavoritesByTopicID(long topicID) throws XException;

    long countViewsByTopicID(long topicID) throws XException;

    long countBookmarksByTopicID(long topicID) throws XException;

    long countFavoritesByUserID(Long userID) throws XException;
    long countViewsByUserID(Long userID) throws XException;
    long countBookmarksByUserID(Long userID) throws XException;

}
