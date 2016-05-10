package com.X.biz.bbs.manager.impl;

import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
@Service("topicManager")
public class TopicManager implements ITopicManager {
    @Override
    public long save(TopicDO topic) throws XException {
        return 0;
    }

    @Override
    public List<TopicDO> queryTopicsWithPage(String topicCategory,int pageNO, int pageNum) throws XException {
        return null;
    }
}
