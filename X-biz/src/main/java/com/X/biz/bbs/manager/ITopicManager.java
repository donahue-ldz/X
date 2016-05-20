package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;

import java.util.List;

/**
 * Created by donahue on 5/10/16.
 */
public interface ITopicManager {
    long save(TopicDO topic, String topicCategory) throws XException;

    TopicDO queryTopicByID(Long id) throws XException;

    void editTopic(Long oldTopicID, TopicDO topicDO, String topicCategory) throws XException;

    List<TopicDO> queryTopicsWithPage(String topicCategory, int pageNO, int pageNum) throws XException;

    long countTopicsByUser(Long userID, String userRole) throws XException;

    long countAllTopics() throws XException;

    List<Long> queryUsers() throws XException;
}
