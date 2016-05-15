package com.X.biz.bbs.manager.impl;

import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicDO;
import com.X.dal.mapper.TopicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
@Service("topicManager")
public class TopicManager implements ITopicManager {
    @Resource
    private TopicMapper topicMapper;

    @Override
    public long save(TopicDO topic) throws XException {
        return topicMapper.save(topic);
    }

    @Override
    public List<TopicDO> queryTopicsWithPage(String topicCategory, int pageNO, int pageNum) throws XException {
        int offSet = pageNO * pageNum;
        return topicMapper.queryTopicsWithPage(topicCategory, offSet, pageNum);
    }
}
