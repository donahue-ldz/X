package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicAndCategoryManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicAndCategoryDO;
import com.X.dal.domain.TopicCategoryDO;
import com.X.dal.mapper.TopicAndCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 8:57 AM
 **/
@Service("topicAndCategoryManager")
@Transactional(rollbackFor = Exception.class)
public class TopicAndCategoryManager implements ITopicAndCategoryManager {
    @Autowired
    private TopicAndCategoryMapper topicAndCategoryMapper;

    @Override
    public long save(final TopicAndCategoryDO topicAndCategory) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                topicAndCategoryMapper.save(topicAndCategory);
                return topicAndCategory.getId();
            }
        }, topicAndCategory);
    }


}
