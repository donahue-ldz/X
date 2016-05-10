package com.X.biz.bbs.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;

import java.util.List;

/**
 * Created by donahue on 5/10/16.
 */
public interface ITopicManager {
    long save(TopicDO topic) throws XException;
    List<TopicDO> queryTopicsWithPage(String topicCategory,int pageNO,int pageNum) throws XException;
}
