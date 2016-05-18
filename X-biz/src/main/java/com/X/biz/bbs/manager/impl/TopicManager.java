package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicAndCategoryManager;
import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import com.X.dal.domain.TopicAndCategoryDO;
import com.X.dal.domain.TopicCategoryDO;
import com.X.dal.domain.TopicDO;
import com.X.dal.mapper.TopicMapper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
@Service("topicManager")

@Transactional(rollbackFor = Exception.class)
public class TopicManager implements ITopicManager {
    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private ITopicAndCategoryManager topicAndCategoryManager;
    @Autowired
    private ITopicCategoryManager topicCategoryManager;

    @Override
    public long save(final TopicDO topic, final String topicCategory) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                topicMapper.save(topic);
                long topicID = topic.getId();

                TopicAndCategoryDO topicAndCategory = new TopicAndCategoryDO();
                TopicCategoryDO topicCategoryDO = topicCategoryManager.queryTopicCategoryByName(topicCategory);
                if (topicCategoryDO == null)
                    throw new XException(String.format("%s not exist", topicCategory));

                topicAndCategory.setTopicID(topicID).setTopicCategoryID(topicCategoryDO.getId());
                topicAndCategory.setGmtCreate(new Date());
                topicAndCategoryManager.save(topicAndCategory);
                return topic.getId();
            }
        }, topic);

    }

    @Override
    public TopicDO queryTopicByID(final Long id) throws XException {
        return RunWrapper.run(new Callable<TopicDO>() {
            @Override
            public TopicDO call() throws Exception {
                return topicMapper.queryTopicByID(id);
            }
        });
    }

    @Override
    public List<TopicDO> queryTopicsWithPage(final String topicCategory, final int pageNO, final int pageNum) throws XException {
        Preconditions.checkArgument(topicCategory != null, "帖子类别不能为空");
        Preconditions.checkArgument(pageNO >= 0, "页码不能为负");
        Preconditions.checkArgument(pageNum >= 0, "记录条数不能为负");
        final int offSet = pageNO * pageNum;
        return RunWrapper.run(new Callable<List<TopicDO>>() {
            @Override
            public List<TopicDO> call() throws Exception {
                return topicMapper.queryTopicsWithPage(topicCategory, offSet, pageNum);
            }
        });
    }
}
