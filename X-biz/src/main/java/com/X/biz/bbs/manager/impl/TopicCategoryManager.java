package com.X.biz.bbs.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.bbs.manager.ITopicCategoryManager;
import com.X.biz.exception.XException;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.TopicCategoryDO;
import com.X.dal.mapper.TopicCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:38 PM
 **/
@Service("topicCategoryManager")
public class TopicCategoryManager implements ITopicCategoryManager {
    @Resource
    private TopicCategoryMapper topicCategoryMapper;

    @Override
    public long save(final TopicCategoryDO topicCategory) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                topicCategoryMapper.save(topicCategory);
                return topicCategory.getId();
            }
        }, topicCategory);
    }

    @Override
    public TopicCategoryDO queryTopicCategoriesByName(final String titleEn) throws XException {
        return RunWrapper.run(new Callable<TopicCategoryDO>() {
            @Override
            public TopicCategoryDO call() throws Exception {
                return topicCategoryMapper.queryTopicCategoriesByName(titleEn);
            }
        });
    }

    @Override
    public List<TopicCategoryDO> queryAllTopicCategories() throws XException {
        return RunWrapper.run(new Callable<List<TopicCategoryDO>>() {
            @Override
            public List<TopicCategoryDO> call() throws Exception {
                return topicCategoryMapper.queryAllTopicCategories();
            }
        });
    }
}
