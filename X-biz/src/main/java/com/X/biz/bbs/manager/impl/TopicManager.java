package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicManager;
import com.X.biz.exception.XException;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.TopicDO;
import com.X.dal.mapper.TopicMapper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:34 PM
 **/
@Service("topicManager")
public class TopicManager implements ITopicManager {
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public long save(final TopicDO topic) throws XException {
        ValidationResult validationResult = ValidateHelper.validateEntity(topic);
        if (validationResult.isHasErrors()) {
            throw new XException(validationResult.toString());
        }
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return topicMapper.save(topic);
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
