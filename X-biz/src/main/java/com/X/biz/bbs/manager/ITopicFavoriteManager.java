package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TopicFavoriteDO;

/**
 * Author zhong.zhou
 * Date 5/17/16
 * Email qnarcup@gmail.com
 */
public interface ITopicFavoriteManager {
    long save(TopicFavoriteDO topicFavorite) throws XException;

    boolean update(long id, int status) throws XException;

    long countFavoritesByTopicID(long topicID) throws XException;
}
